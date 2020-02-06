package com.ust.mail_simulator.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.mail_simulator.model.Mail_info;
import com.ust.mail_simulator.model.User_info;

public interface Mail_DAO {

	boolean register(User_info dto);
    public User_info login(User_info dto);
    public List<Mail_info> inbox();
	public List<Mail_info> sent();
	public List<Mail_info> deleteItem();
	public List<Mail_info> draft();
	boolean composeEmail(HttpServletRequest req);
	boolean delete(int id);
	boolean forgetPassword(HttpServletRequest req);
	boolean changePassword(HttpServletRequest req);
	List<Mail_info> mail(int id);
	Mail_info composeDraft(int id);
	boolean composeEmailDraft(HttpServletRequest req);
	boolean sentdelete(int id);
	boolean inboxdelete(int id);
	boolean draftdelete(int id);
}
