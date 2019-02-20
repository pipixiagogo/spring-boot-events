package com.flair.springbootevents.service;

import com.flair.springbootevents.Entity.Person;
import com.flair.springbootevents.excel.ExcelExportUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public void export(HttpServletRequest request, HttpServletResponse response){
        List<Person>list=new ArrayList<>();
        for(int i=0;i<10;i++){
            Person person=new Person("张三12333333333333333333333333333333333333333333333",15+i,"湖南","东北");
            list.add(person);
        }
        fillResponse("Excel导出",response,request,list);
    }

    //填充返回内容
    private void fillResponse(String fileName,HttpServletResponse response,HttpServletRequest request, List<Person> ds) {
        //创建ExcelExportUtil对象时候就会进行反射
        ExcelExportUtil<Person> util = new ExcelExportUtil<>( Person.class );
        for(Person person:ds){
            util.fillObject(person);
        }
        OutputStream out = null;
        try {
            out =  response.getOutputStream();
            response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
            String agent = request.getHeader("USER-AGENT");
            if(agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                fileName =  new String(fileName.getBytes("UTF-8"),"iso-8859-1");
            }else{
                fileName =  java.net.URLEncoder.encode(fileName, "UTF-8");
            }
            response.setHeader("Content-Disposition","attachment;filename=" + fileName + ".xls");
            response.setContentType("application/vnd.ms-excel");//定义输出类型
            util.write( out );
        }catch (Exception e){
            return;
        }finally {
            if( out != null ){
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
