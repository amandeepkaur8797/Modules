package com.ust.mail_simulator.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mail_simulator.dao.Mail_DAO;
import com.ust.mail_simulator.model.Mail_info;
import com.ust.mail_simulator.model.User_info;

@Component
public class Mail_ServiceImp implements Mail_Service{
	@Autowired
	Mail_DAO mdao;
	
	@Override
	public boolean register(User_info dto) {
		boolean b=mdao.register(dto);
		return b;
	}

	@Override
	public User_info login(User_info dto) {
		User_info mdto=mdao.login(dto);
		return mdto;
	}

	@Override
	public List<Mail_info> inbox() {
		// TODO Auto-generated method stub
		List<Mail_info> From_id=mdao.inbox();
		return From_id;
	}

	@Override
	public List<Mail_info> sent() {
		// TODO Auto-generated method stub
		List<Mail_info> From_id=mdao.sent();
		return From_id;
	}

	@Override
	public List<Mail_info> deleteItem() {
		// TODO Auto-generated method stub
		List<Mail_info> From_id=mdao.deleteItem();
		return From_id;
	}

	@Override
	public List<Mail_info> draft() {
		// TODO Auto-generated method stub
		List<Mail_info> From_id=mdao.draft();
		return From_id;
	}

	@Override
	public boolean composeEmail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return mdao.composeEmail(req);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean b=mdao.delete(id);
		return b;
	}

	@Override
	public boolean forgetPassword(HttpServletRequest req) {
		return mdao.forgetPassword(req);
	}

	@Override
	public boolean changePassword(HttpServletRequest req) {
		boolean b= mdao.changePassword(req);
		return b;
	}

	@Override
	public List<Mail_info> mail(int id) {
		List<Mail_info> From_id=mdao.mail(id);
		return From_id;
	}

	@Override
	public Mail_info composeDraft(int id) {
	    Mail_info From_id=mdao.composeDraft(id);
	    return From_id;
	}

	@Override
	public boolean composeEmailDraft(HttpServletRequest req) {
		return mdao.composeEmailDraft(req);
	}

	@Override
	public boolean sentdelete(int id) {
		boolean b=mdao.sentdelete(id);
		return b;
	}

	@Override
	public boolean inboxdelete(int id) {
		boolean b=mdao.inboxdelete(id);
		return b;
	}

	@Override
	public boolean draftdelete(int id) {
		boolean b=mdao.draftdelete(id);
		return b;
	}

	

	
	
}
