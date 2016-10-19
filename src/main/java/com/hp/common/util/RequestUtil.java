package com.hp.common.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	public static String getUserAgent(HttpServletRequest request){
		   String[] mobileAgents = {"iphone","android","phone","mobile","wap","netfront","java","opera mobi","opera mini","ucweb","windows ce","symbian","series","webos","sony","blackberry","dopod","nokia","samsung","palmsource","xda","pieplus","meizu","midp","cldc","motorola","foma","docomo","up.browser","up.link","blazer","helio","hosin","huawei","novarra","coolpad","webos","techfaith","palmsource","alcatel","amoi","ktouch","nexian","ericsson","philips","sagem","wellcom","bunjalloo","maui","smartphone","iemobile","spice","bird","zte-","longcos","pantech","gionee","portalmmm","jig browser","hiptop","benq","haier","^lct","320x320","240x320","176x220","w3c ","acs-","alav","alca","amoi","audi","avan","benq","bird","blac","blaz","brew","cell","cldc","cmd-","dang","doco","eric","hipt","inno","ipaq","java","jigs","kddi","keji","leno","lg-c","lg-d","lg-g","lge-","maui","maxo","midp","mits","mmef","mobi","mot-","moto","mwbp","nec-","newt","noki","oper","palm","pana","pant","phil","play","port","prox","qwap","sage","sams","sany","sch-","sec-","send","seri","sgh-","shar","sie-","siem","smal","smar","sony","sph-","symb","t-mo","teli","tim-","tosh","tsm-","upg1","upsi","vk-v","voda","wap-","wapa","wapi","wapp","wapr","webc","winw","winw","xda","xda-","Googlebot-Mobile"};
		   String  agentType = "PC";
		   if(request.getHeader("User-Agent")!=null){
			   for(int i=0;i<mobileAgents.length;i++){
				   if(request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgents[i])>=0){
					   if(request.getHeader("User-Agent").toLowerCase().indexOf("android")>0){
						   agentType = "android";
					   }else if(request.getHeader("User-Agent").toLowerCase().indexOf("iphone")>0){
						   agentType = "iphone";
					   }else{
						   agentType = "phone";
					   }
					   break;
				   }
			   }
		   }
		   return agentType;
	}
	
	public static String getUserIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	    return ip;
	}
	
	public static String getRequestUrl(HttpServletRequest request){
		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");
		return requestUrl;
	}
}
