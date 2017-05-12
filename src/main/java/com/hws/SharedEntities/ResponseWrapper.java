package com.hws.SharedEntities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihor on 5/7/2017.
 */
@Data
public class ResponseWrapper<T> {

    public Boolean IsSuccess;
    public List<String> ErrorMessages;

    public T ResponseData;

    public ResponseWrapper(){
        IsSuccess = true;
        ErrorMessages = new ArrayList<>();
    }

    public void AddErrorMessage(String message){
        IsSuccess = false;
        ErrorMessages.add(message);
    }

    public String getErrorMessage(){
        StringBuilder builder = new StringBuilder();

        for(String message : ErrorMessages){
            builder.append(message);
        }

        return builder.toString();
    }
}
