package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IBookingService;
import com.hws.Services.security.interfaces.IUserProfileService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Booking;
import com.hws.hibernate.models.Customer;
import com.hws.hibernate.models.User;
import com.util.StringUtil;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/17/2017.
 */
@Controller
public class UserController extends ControllerBase {

    @Autowired
    IUserProfileService userProfileService;

    @Autowired
    IBookingService bookingService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Index", method = RequestMethod.GET)
    public ModelAndView userHome() {
        ModelAndView model = new ModelAndView("User/Index");
        model.addObject("UserName", this.getCurrentUserName());
        return model;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Profile", method = RequestMethod.GET)
    public ModelAndView userProfile(User user, String errorMessage, String success) {
        ModelAndView model = new ModelAndView("User/Profile");

        User currentUser;
        if (user == null || user.getUserId() == null) {
            currentUser = getUser();
        } else {
            currentUser = user;
        }

        if (currentUser.getCustomer() == null) {
            currentUser.setCustomer(new Customer());
        }

        model.addObject("userProfile", currentUser);

        if (errorMessage != null){
            model.addObject("errorMessage", errorMessage);
        }
        else if (success != null){
            model.addObject("success", "Your changes was saved successfully!");
        }

        ResponseWrapper<List<Booking>> bookingsResult = bookingService.GetCustomerBookings(getUser().getCustomerId());

        model.addObject("userBookings", bookingsResult.ResponseData);

        return model;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Profile", method = RequestMethod.POST)
    @ModelAttribute("com/hws/hibernate/models/User.java")
    public ModelAndView saveProfile(User userProfile) {
        ResponseWrapper<User> response = userProfileService.UpdateUserProfile(userProfile);

        if (response.IsSuccess) {
            return new ModelAndView("redirect:/Secured/User/Profile?success=true");
        }

        ModelAndView model = new ModelAndView("User/Profile");
        model.addObject("userProfile", response.ResponseData);
        model.addObject("errorMessage", String.join("</br>", response.ErrorMessages));
        return model;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/DeleteBooking", method = RequestMethod.POST)
    public ModelAndView saveProfile(String bookingUUID) {

        if (StringUtil.IsNullOrEmpty(bookingUUID)){
            return null;
        }

        ResponseWrapper<Boolean> response = bookingService.RemoveBooking(UUID.fromString(bookingUUID));
        ResponseWrapper<List<Booking>> bookingsResult = bookingService.GetCustomerBookings(getUser().getCustomerId());

        ModelAndView model = new ModelAndView("User/UserBookings");
        model.addObject("deleteResult", response.IsSuccess);
        model.addObject("userBookings", bookingsResult.ResponseData);
        return model;
    }
}
