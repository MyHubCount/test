//package mybatis;
//
///**
// * @Author: wangxin * @Date: 2018/7/19 15:22 * @Description: *
// */
//public class Test001 {
//
//
//    String data =
//            "{'berth':'','fareCulation':'','flightList':[{'bagage':'','clssOfService':'Y','dest':'PEK','destTerminal':'T3','dptTime':'2018-6-20 18:15','flightNo':'3U8895','origin':'CTU','takeoffDate':'2018-6-20','takeoffTerminal':'T1','takeoffTime':'2018-6-20 15:20','team':'','useStatus':''},{'bagage':'','clssOfService':'F','dest':'PEK','destTerminal':'T5','dptTime':'2018-6-20 18:15','flightNo':'TY8895','origin':'CTU','takeoffDate':'2018-6-20','takeoffTerminal':'T4','takeoffTime':'2018-6-20 15:20','team':'','useStatus':''}],'isVip':'VIP/P1','passengerDetrs':[{'detr':'8762397479480','fareCulation':'20JUN18 CTU3U PEK1470.00CNY1470.00END','flightList':[{'bagage':'20K','clssOfService':'Y','dest':'PEK','destTerminal':'T3','dptTime':'','flightNo':'3U8895','origin':'CTU','takeoffDate':'2018-6-20','takeoffTerminal':'T1','takeoffTime':'2018-6-20 15:20','team':'true','useStatus':'OPEN FOR USE'}],'passengerName':'何庆强GC','pnr':'NK4GYK','taxTate':'50.00CN 10.00YQ','ticketPrice':'1530.00','ticketRate':'1470.00'},{'detr':'8762397479480','fareCulation':'20JUN18 CTU3U PEK1470.00CNY1470.00END','flightList':[{'bagage':'20K','clssOfService':'Y','dest':'PEK','destTerminal':'T3','dptTime':'','flightNo':'3U8895','origin':'CTU','takeoffDate':'2018-6-20','takeoffTerminal':'T1','takeoffTime':'2018-6-20 15:20','team':'true','useStatus':'FIM EXCH'}],'passengerName':'杨国庆','pnr':'NK4GYK','taxTate':'50.00CN 10.00YQ','ticketPrice':'1530.00','ticketRate':'1470.00'},{'detr':'8762397479480','fareCulation':'20JUN18 CTU3U PEK1470.00CNY1470.00END','flightList':[{'bagage':'20K','clssOfService':'Y','dest':'PEK','destTerminal':'T3','dptTime':'','flightNo':'3U8895','origin':'CTU','takeoffDate':'2018-6-20','takeoffTerminal':'T1','takeoffTime':'2018-6-20 15:20','team':'true','useStatus':'AIRP CNTL/YY'}],'passengerName':'陈军全','pnr':'NK4GYK','taxTate':'50.00CN 10.00YQ','ticketPrice':'1530.00','ticketRate':'1472.00'}],'passengerName':'1.陈军全,2.何庆强,3.杨国庆','passengerPhone':'13980956582','passengerType':'UMNR/P1,AVIH/P1,AVIH/P3,VIP/P1','pnr':'NK4GYK','saleDate':'2018-06-19 14:52','sumMoney':0,'taxTate':'','team':false,'ticketNum':'8762397479478,8762397479479,8762397479480','ticketPrice':'','ticketRate':'','useStatus':''}";
//    PassengerConf passengerConf = JsonUtil.toBean(data,PassengerConf.class);
//    //ArrayList<FlightList> list = passengerConf.getFlightList();
//        System.out.println(passengerConf);
//    ArrayList<PassengerDetr> passengerDetrs = passengerConf.getPassengerDetrs();
//
//        for (PassengerDetr o: passengerDetrs
//             ) {
//        String ticketNum = o.getDetr();//拿到票号
//        //模拟通过票号进行的查询操作并返回一个实体
//        System.out.println("----------通过票号查询--------------");
//        PassengerDetr passengerDetr = new PassengerDetr();
//        if (passengerDetr != null){//已在数据库有相应数据
//            //跳出
//        }else{
//            //执行插入旅客信息的操作(但需要去除航班信息)
//            for (FlightList f: o.getFlightList()
//                    ) {
//                //保存航班信息
//                //System.out.println(f.toString());
//            }
//        }
//
//        //System.out.println(o.toString());
//    }
//}
//
//}
