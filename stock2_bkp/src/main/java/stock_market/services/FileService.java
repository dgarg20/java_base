package com.dgarg20.stock_market.services;

import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.entities.OrderType;
import com.dgarg20.stock_market.exception.ServiceException;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public class FileService {

    public List<OrderRequest> getOrdersFromFile(String filePath) throws ServiceException {
        try {
            File f = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            int line =0;
            String st;
            List<OrderRequest> orderRequestList = new LinkedList<>();
            while ((st = br.readLine()) != null) {
                line ++;
                orderRequestList.add(processOrderLine(st, line));
            }
            return orderRequestList;
        } catch (FileNotFoundException f){
            throw new ServiceException("400", "File with the provided name not found");
        } catch (IOException e) {
            throw new ServiceException("400", "Unable to read File");
        } catch (ServiceException ex){
            throw ex;
        }
    }

    private OrderRequest processOrderLine(String s, int line) throws ServiceException {
        try {
            String[] data = s.split(" ");
            if (data.length != 6) {
                throw new ServiceException("400", "Input Format not proper in line " + line);
            }

            return new OrderRequest(data[0], parseTime(data[1]), data[2], HelperMethods.searchEnum(OrderType.class, (data[3])), getPrice(data[4]),
                    getQty(data[5]));
        } catch (ServiceException ex){
            ex.setMessage(ex.getMessage() + " at line #" + line);
            throw ex;
        }
    }

    private float getPrice(String s)throws ServiceException {
        try {
            return Float.parseFloat(s);
        }
        catch (Exception ex) {
            throw new ServiceException("400", "Price value Incorrect");
        }
    }

    private int getQty(String s)throws ServiceException {
        try {
            return Integer.parseInt(s);
        }
        catch (Exception ex) {
            throw new ServiceException("400", "Qty value should be in int");
        }
    }


    private LocalTime parseTime(String time)throws ServiceException{
        try {
            DateTimeFormatter timeFormatter =  DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(time, timeFormatter);
        }catch (Exception ex) {
            throw new ServiceException("400", "Input Format not proper in line ");
        }
    }
}
