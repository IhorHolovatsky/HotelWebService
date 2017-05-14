package com.hws.controllers;

import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * Created by Ihor on 5/14/2017.
 */
@Controller
public class ImageController extends ControllerBase {

    @Autowired
    IRoomDAO roomDAO;

    @RequestMapping(value = "/GetImage", method = RequestMethod.GET)
    public ResponseEntity<byte[]> GetImage(String roomId, HttpServletRequest request, HttpServletResponse response) {
        if (roomId == null)
            return null;

        Room room = roomDAO.GetRoomById(UUID.fromString(roomId));

        //Save image to database
//        File file = new File("G:\\79119896.jpg");
//        byte[] bFile = new byte[(int) file.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            //convert file into array of bytes
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        room.setImage(bFile);
//        roomDAO.UpdateRoom(room);

        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(room.getImage(), headers, HttpStatus.OK);
    }

}
