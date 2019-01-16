/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.WeekModel;
import model.batch_status;

/**
 *
 * @author faisal-shakiba
 */
public class DateParse {
    private TimeZone timeZone;
 
    public DateParse()
    {
        this.timeZone=TimeZone.getDefault();
    }
    public int weekOfDate(Date date)
    {
        Calendar ca=Calendar.getInstance();
        ca.setTime(date);
        int i=ca.get(Calendar.WEEK_OF_MONTH);
        System.out.println("Week: "+i);
        return i;
    }
    public String monthBalance(String monthString)
    {
        String mString="";
        String[] mArray=monthString.split("/");
        int m=Integer.parseInt(mArray[1])-1;
        mString =mArray[0]+"/"+m+"/"+mArray[2];
        return mString;
    }
    public String findDayOfTheWeek(int i)
    {
       String  day="";
       if(i==Calendar.FRIDAY)
           day="fri";
       else if(i==Calendar.SATURDAY)
           day="sat";
       else if(i==Calendar.SUNDAY)
           day="sun";
       else if(i==Calendar.MONDAY)
           day="mon";
       else if(i==Calendar.TUESDAY)
           day="tue";
       else if(i==Calendar.WEDNESDAY)
           day="wed";
       else if(i==Calendar.THURSDAY)
           day="thu";
       return day;
       
                   
    }
    public List<batch_status> rangeSelection(batch_status bstatus,List<WeekModel> weeklist,String startDate,String endDate)
    {
        List<batch_status> dateList=new ArrayList<>();
        
        startDate=monthBalance(startDate);
        endDate=monthBalance(endDate);
        String[] sArray=startDate.split("/");
        int sDate=Integer.parseInt(sArray[0]);
        int sMonth=Integer.parseInt(sArray[1]);
        int syear=Integer.parseInt(sArray[2]);
        
         String[] eArray=endDate.split("/");
        int eDate=Integer.parseInt(eArray[0]);
        int eMonth=Integer.parseInt(eArray[1]);
        int eyear=Integer.parseInt(eArray[2]);
        int weeksize=weeklist.size();
        int weekCount=0;
        int weekEnd=0;
        int enweek=0;
        try {
            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            weekCount=weekOfDate(date);
            Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            enweek=weekOfDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(DateParse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       // String out=start
       boolean flag=false;
       System.out.println("Strated: "+startDate);
       System.out.println("Ended: "+endDate);
      while(true)
        {
            if(flag==true)
                break;
            
            for(int i=0;i<weeksize;i++){
          String out=  nthWeekdayOfMonth(weeklist.get(i).getDay(), sMonth, syear, weekCount);
          System.out.println("----- Date -----"+out);
          batch_status b=new batch_status(bstatus.getAttendance(),bstatus.getBatch_code(),out,findDayOfTheWeek(weeklist.get(i).getDay()),weeklist.get(i).getStartTime(), weeklist.get(i).getOutTime(),bstatus.getIntime(), bstatus.getOuttime(),bstatus.getStatus(), bstatus.getTrainer_name(),bstatus.getUniversity_name());
//          b.setDate(out);
//          b.setDay(findDayOfTheWeek(weeklist.get(i)));
          dateList.add(b);
          String[] outArray=out.split("/");
        System.out.println("Current month: "+(Integer.parseInt(outArray[1])-1));
        
        String cDate="";
       

        cDate=outArray[0]+"/"+(Integer.parseInt(outArray[1])-1)+"/"+outArray[2];
        System.out.println("Current date: "+cDate);
        if(cDate.endsWith(endDate))
        {
            flag=true;
            break;
        }

            }
            weekCount++;
            
        }
         return dateList;
    }
    public String nthWeekdayOfMonth(int dayOfWeek, int month, int year, int week) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(timeZone);
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    // add +1 to week if first weekday of mounth > dayOfWeek
    int localWeek = week;
    if (calendar.get(calendar.DAY_OF_WEEK) > dayOfWeek) {
        localWeek++;
    }
    calendar.set(Calendar.WEEK_OF_MONTH, localWeek);
    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
      String s=format.format(calendar.getTime());
    return s;
}

    boolean nthWeekdayOfMonth(int FRIDAY, Class c, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
