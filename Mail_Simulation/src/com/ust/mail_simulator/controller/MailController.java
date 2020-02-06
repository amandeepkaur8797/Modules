package com.ust.mail_simulator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ust.mail_simulator.model.Mail_info;
import com.ust.mail_simulator.model.User_info;
import com.ust.mail_simulator.service.Mail_Service;


@Component
@RequestMapping("/")
public class MailController {
	@Autowired
	Mail_Service gs;
	
	@Autowired
	HttpSession hs;
	
	
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	
	@RequestMapping("/registration")
	public String registration(){
		return "registration";
	}
	
	@RequestMapping("/compose")
	public ModelAndView composemail(){
		if(hs.getAttribute("email")!=null) {
		return new ModelAndView("compose");
	}else {
		  return new ModelAndView("login","msg3","Login First!!!!");
	  }
	}
	
	@RequestMapping("/forgetpassword")
	public String forgetpassword(){
		return "forgetPass";
	}
	
	@RequestMapping("/inbox")
	public ModelAndView inbox(){
		if(hs.getAttribute("email")!=null) {
		List<Mail_info> From_id=gs.inbox();
	
		return new ModelAndView("inbox","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	
	@RequestMapping("/sent")
	public ModelAndView sent(){
		if(hs.getAttribute("email")!=null) {
		List<Mail_info> From_id=gs.sent();
		return new ModelAndView("sent","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	@RequestMapping("/deleteitem")
	public ModelAndView deleteitem(){
		if(hs.getAttribute("email")!=null) {
		List<Mail_info> From_id=gs.deleteItem();
		return new ModelAndView("deleteItem","From_id",From_id);
	  }else {
		  return new ModelAndView("login","msg3","Login First!!!!");
	  }
	}
	@RequestMapping("/draft")
	public ModelAndView draft(){
		if(hs.getAttribute("email")!=null) {
		List<Mail_info> From_id=gs.draft();
		return new ModelAndView("draft","From_id",From_id);
		 }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
		}
	
	@RequestMapping("/mail")
	public ModelAndView mailpage(@RequestParam int id){
		if(hs.getAttribute("email")!=null) {
		List<Mail_info> From_id=gs.mail(id);
		return new ModelAndView("mail","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	
	@RequestMapping("/composedraft")
	public ModelAndView composedraft(@RequestParam int id){
		if(hs.getAttribute("email")!=null) {
		Mail_info From_id=gs.composeDraft(id);
		return new ModelAndView("composedraft","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	
	@RequestMapping(value="/composedraftData",method=RequestMethod.POST)
	public ModelAndView composedraftData(HttpServletRequest req){
		if(hs.getAttribute("email")!=null) {
		boolean b=gs.composeEmailDraft(req);
		if(b) {
		return new ModelAndView("home","msg1","Mail Sent Done");
		  }else {
			  return new ModelAndView("home","msg1","Mail Sent Not Done");
		  }
		  }else{
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	
	
	
	
	@RequestMapping(value="/loginValidation",method=RequestMethod.POST)
	public ModelAndView loginValidation(@ModelAttribute User_info dto, HttpServletRequest req){
		User_info mdto=gs.login(dto);
		if(mdto!=null){
			hs=req.getSession();
			hs.setAttribute("email", dto.getEmail());
			System.out.println("Login Success");
			return new ModelAndView("home","data",mdto);
		}else{
			System.out.println("Login Failed");
			return new ModelAndView("login","msg","login failed invalid email and password try again");
		}
		
	}
	
	@RequestMapping(value="/registrationData",method=RequestMethod.POST)
	public ModelAndView registrationData(@ModelAttribute User_info dto){
		boolean b=gs.register(dto);
		System.out.println("Registration Success");
		if(b){
		return new ModelAndView("registration","dto","Registration Done");
		}else{
		return new ModelAndView("registration","dto","Registration Not Done User already Existed");	
		}
	}
	
	@RequestMapping(value="/composeData",method=RequestMethod.POST)
	public ModelAndView composeEmail(HttpServletRequest req){
		
		if(hs.getAttribute("email")!=null) {
		boolean b=gs.composeEmail(req);
		if(b){
			return new ModelAndView("home","msg1","Mail Successfully Sent");
			
		}else{
			return new ModelAndView("home","msg1","Mail saved to drafts");
		}
		}else{
			return new ModelAndView("login","msg3","Login First!!!");
		}
	
	}
	
	 /*@RequestMapping("/delete")
	  public ModelAndView delete(@RequestParam int id) {
		  
		  boolean b=gs.delete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("home","msg","delete failed");
		  }
	  }*/
	
	@RequestMapping(value="/forgetPassword",method=RequestMethod.POST)
	public ModelAndView forgetpassword(HttpServletRequest req){
		
		
		boolean b=gs.forgetPassword(req);
		if(b){
			return new ModelAndView("changePass");
			
		}else{
			return new ModelAndView("forgetPass","msg1","Security validation is wrong");
		}
		
	}
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public ModelAndView changePass(HttpServletRequest req) {
		System.out.println("Change password");
		boolean b=gs.changePassword(req);
		System.out.println(b+" b");
		if(b){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("changePass","msg","Password Not Changed.. Confirm Password and New Password are not same.");
		}
	}


    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest req){
	System.out.println("logout");
	 if(hs.getAttribute("email")!=null) {
		hs.setAttribute("email",null);
		 return new ModelAndView("login","msg2","Logout Successful.. Login First");
		}else{
		return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
	}
   }
    
    @RequestMapping("/sentdelete")
	  public ModelAndView sentdelete(@RequestParam int id) {
		 if(hs.getAttribute("email")!=null) { 
					  
		  boolean b=gs.sentdelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("home","msg","delete failed");
		  }
	 }else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	  }
    
    @RequestMapping("/inboxdelete")
	  public ModelAndView inboxdelete(@RequestParam int id) {
		if(hs.getAttribute("email")!=null) { 
		  boolean b=gs.inboxdelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("home","msg","delete failed");
		  }
	}else{
		return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
	}
  }
    
	@RequestMapping("/draftdelete")
	  public ModelAndView draftdelete(@RequestParam int id) {
		if(hs.getAttribute("email")!=null) { 
		  boolean b=gs.draftdelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("home","msg","delete failed");
		  }
		}else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	  }
	
}
