package com.ust.mail_simulator.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mail_simulator.model.Mail_info;
import com.ust.mail_simulator.model.User_info;

@Component
public class Mail_DAOImp implements Mail_DAO{
	@Autowired 
	SessionFactory sf;
	
	@Autowired
	HttpSession hs;
	
	@Override
	public boolean register(User_info dto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", dto.getEmail()));
		User_info mdto=(User_info) cr.uniqueResult();
		System.out.println("mdto"+mdto);
		if(mdto==null){
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else{
			ss.close();
			return false;
		}	
	}

	@Override
	public User_info login(User_info dto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", dto.getEmail()));
		cr.add(Restrictions.eq("password", dto.getPassword()));
		User_info mdto=(User_info) cr.uniqueResult();
		ss.close();
		return mdto;
		
	}

	@Override
	public List<Mail_info> inbox() {
		Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email",email));
		User_info udto1= (User_info) cr.uniqueResult();
		int id=udto1.getId();
		Criteria cr1 =ss.createCriteria(Mail_info.class);
		cr1.add(Restrictions.eq("To_id",id));
		Criterion status = Restrictions.ne("Status","draft");
		Criterion status1=Restrictions.ne("Status","inboxdeleted");
		Criterion status2=Restrictions.eq("Status","sentdeleted" );
	    Criterion oneCondition = Restrictions.conjunction().add(status).add(status1);
		Criterion completeCondition = Restrictions.disjunction().add(oneCondition).add(status2);
        cr1.add(completeCondition);
		List<Mail_info> mlist=cr1.list();
        ss.close();
		return mlist;
		
		
		/*Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email",email));
		User_info udto1= (User_info) cr.uniqueResult();
		int id=udto1.getId();

		Query q=ss.createQuery(" from Mail_info where To_id=? and Status!=? and Status!=?");
		q.setParameter(0,id);
		q.setParameter(1,"Deleted Mail");
		q.setParameter(2,"draft");
		List<Mail_info> mlist=q.list();

		ss.close();
		return mlist;*/
	}

	@Override
	public List<Mail_info> sent() {
		Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email",email));
		User_info udto1= (User_info) cr.uniqueResult();
		int id=udto1.getId();
		Criteria cr1 =ss.createCriteria(Mail_info.class);
		Criterion sentby = Restrictions.eq("sentby",email);
		Criterion status = Restrictions.eq("Status","sent");
		Criterion status2=Restrictions.ne("Status","sentdeleted");
		Criterion status1=Restrictions.eq("Status","inboxdeleted" );
		Criterion oneCondition = Restrictions.conjunction().add(status).add(sentby).add(status2);
		Criterion completeCondition = Restrictions.disjunction().add(oneCondition).add(status1);
        cr1.add(completeCondition);
		List<Mail_info> mlist=cr1.list();
		ss.close();
		return mlist;
		
		
		/*Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email",email));
		User_info udto1= (User_info) cr.uniqueResult();
		int id=udto1.getId();
		Criteria cr1 =ss.createCriteria(Mail_info.class);
		cr1.add(Restrictions.eq("sentby",email));
		cr1.add(Restrictions.eq("Status","sent"));
		List<Mail_info> mlist=cr1.list();
		ss.close();
		return mlist;*/
	}

	@Override
	public List<Mail_info> deleteItem() {
		Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Query q=ss.createQuery("from Mail_info where (Status=? OR Status=? OR Status=?) and (sentby=? OR sentto=?)");
		q.setParameter(0,"sentdeleted");
		q.setParameter(1,"inboxdeleted");
		q.setParameter(2,"draftdeleted");
		q.setParameter(3, email);
		q.setParameter(4, email);
		List<Mail_info> mlist=q.list();
		ss.close();
		return mlist;
		
		
		/*Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", email));
		User_info udto=(User_info) cr.uniqueResult();
		int id=udto.getId();
		Criteria cr1=ss.createCriteria(Mail_info.class);
		cr1.add(Restrictions.eq("sentto", email));
		Query q=ss.createQuery("from Mail_info where Status=? and (sentby=? OR sentto=?)");
		q.setParameter(0, "Deleted Mail");
		q.setParameter(1, email);
		q.setParameter(2, email);
		List<Mail_info> mlist=q.list();
		ss.close();
		return mlist;*/
   }

	@Override
	public List<Mail_info> draft() {
		Session ss=sf.openSession();
		String email=(String) hs.getAttribute("email");
		int id=0;
		Criteria cr1 =ss.createCriteria(Mail_info.class);
		cr1.add(Restrictions.eq("To_id",id));
		cr1.add(Restrictions.eq("sentby",email));
		cr1.add(Restrictions.ne("Status","draftdeleted"));
		List<Mail_info> mlist=cr1.list();
		ss.close();
		return mlist;
	}

	@Override
	public boolean composeEmail(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("To");
		String subject=req.getParameter("Subject");
		String message= req.getParameter("Message");
		this.hs = req.getSession(false);
		String from = (String) hs.getAttribute("email");
		Mail_info mdto= null;
		Mail_info mdto1= null;
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email",to));
		User_info udto= (User_info) cr.uniqueResult();
	
		if(udto!=null){
			int toid=udto.getId();
			mdto=new Mail_info();
			mdto.setMessage(message);
			mdto.setSubject(subject);
			mdto.setSentby(from);
			mdto.setTo_id(toid);
		    mdto.setStatus("sent");
		    mdto.setSentto(to);
			
			Criteria cr1 = ss.createCriteria(User_info.class);
			cr1.add(Restrictions.eq("email",from));
			User_info udto1= (User_info) cr1.uniqueResult();
			List<Mail_info> From_id = udto1.getFrom_id();
			From_id.add(mdto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();
			return true;
			
		}else{
			mdto =new Mail_info();
			mdto.setMessage(message);
			mdto.setSubject(subject);
			mdto.setTo_id(0);
			mdto.setSentby(from);
		    mdto.setStatus("draft");
			mdto.setSentto(to);
			Criteria cr1 =ss.createCriteria(User_info.class);
			cr1.add(Restrictions.eq("email",from));
			User_info udto1=(User_info) cr1.uniqueResult();
			int toid1=udto1.getId();
			List<Mail_info> From_id=udto1.getFrom_id();
			From_id.add(mdto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			
			mdto1 =new Mail_info();
			mdto1.setMessage("Mail Delivery Failed");
			mdto1.setSubject("Mail Delivery Failed");
			mdto1.setStatus("Mail Delivery failed");
			mdto1.setSentby("service@gmail.com");
			mdto1.setTo_id(toid1);
            mdto1.setSentto(from);
			
			Criteria cr2 =ss.createCriteria(User_info.class);
			cr2.add(Restrictions.eq("email","service@gmail.com"));
			User_info udto2=(User_info) cr2.uniqueResult();
			List<Mail_info> Fromid=udto2.getFrom_id();
			Fromid.add(mdto1);
			ss.saveOrUpdate(udto2);
			ss.beginTransaction().commit();
			ss.close();
			return false;
		}	
	}

	@Override
	public boolean delete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		Mail_info dto=(Mail_info) cr.uniqueResult();
		boolean b=false;
		if(dto!=null) {
			
			Mail_info mdto=(Mail_info) cr.uniqueResult();
			String status = mdto.getStatus();
			System.out.println(status+"status");
			id =mdto.getId();
			if(status.equalsIgnoreCase("Deleted Mail")){
				Mail_info rdto=ss.load(Mail_info.class,id);
				System.out.println(rdto+"rdto");
				ss.delete(rdto);
				ss.beginTransaction().commit();
				b=true;
			}else{
			dto.setStatus("Deleted Mail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			
			b= true;
		}
		}else {
		b= false;
		}
		return b;
	}

	@Override
	public boolean forgetPassword(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String question=req.getParameter("Question");
		String answer=req.getParameter("answer");
		Criteria cr1 =ss.createCriteria(User_info.class);
		cr1.add(Restrictions.eq("email",email));
		cr1.add(Restrictions.eq("question",question));
		cr1.add(Restrictions.eq("answer",answer));
		User_info dto=(User_info) cr1.uniqueResult();
		if(dto!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean changePassword(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		boolean b=false;
		String confirmpass=req.getParameter("confirmpassword");
		String newpass=req.getParameter("newpassword");
		System.out.println(confirmpass+"confirmpass");
		System.out.println(newpass+"newpass");
		if(!confirmpass.equals(newpass)){
			 b=false;
		}else{
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", email));
		User_info udto=(User_info) cr.uniqueResult();
		System.out.println(udto+"udto");
		if (udto!=null) {
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			b=true;
		} else {
			b= false;
		}
	  }
		return b;
	}

	@Override
	public List<Mail_info> mail(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		List<Mail_info> mlist=cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public Mail_info composeDraft(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		Mail_info m=(Mail_info) cr.uniqueResult();
		ss.close();
		return m;
	}

	@Override
	public boolean composeEmailDraft(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("To");
		String subject=req.getParameter("Subject");
		String message=req.getParameter("Message");
		String id=req.getParameter("Id");
		int id1=Integer.parseInt(id);
		this.hs=req.getSession(false);
		String from=(String) hs.getAttribute("email");
		Mail_info mdto=null;
		Mail_info mdto1=null;
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", to));
		User_info udto=(User_info) cr.uniqueResult();
		if(udto!=null){
		int toid=udto.getId();
		Mail_info mdto11=ss.load(Mail_info.class, id1);	
			mdto11.setMessage(message);
			mdto11.setSubject(subject);
			mdto11.setSentby(from);
			mdto11.setTo_id(toid);
			mdto11.setStatus("sent");
			mdto11.setSentto(to);
			
			Criteria cr1=ss.createCriteria(User_info.class);
			cr1.add(Restrictions.eq("email", from));
			User_info udto1=(User_info) cr1.uniqueResult();
			List<Mail_info> From_id=udto1.getFrom_id();
			From_id.add(mdto11);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else{
			Mail_info mdto2=ss.load(Mail_info.class,id1);
			mdto2.setMessage(message);
			mdto2.setSubject(subject);
			mdto2.setTo_id(0);
			mdto2.setSentby(from);
		    mdto2.setStatus("draft");
			mdto2.setSentto(to);
			Criteria cr1 =ss.createCriteria(User_info.class);
			cr1.add(Restrictions.eq("email",from));
			User_info udto1=(User_info) cr1.uniqueResult();
			int toid1=udto1.getId();
			List<Mail_info> From_id=udto1.getFrom_id();
			From_id.add(mdto2);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			
			mdto1 =new Mail_info();
			mdto1.setMessage("Mail Delivery Failed");
			mdto1.setSubject("Mail Delivery Failed");
			mdto1.setStatus("Mail Delivery failed");
			mdto1.setSentby("service@gmail.com");
			mdto1.setTo_id(toid1);
            mdto1.setSentto(from);
			
			Criteria cr2 =ss.createCriteria(User_info.class);
			cr2.add(Restrictions.eq("email","service@gmail.com"));
			User_info udto2=(User_info) cr2.uniqueResult();
			List<Mail_info> Fromid=udto2.getFrom_id();
			Fromid.add(mdto1);
			ss.saveOrUpdate(udto2);
			ss.beginTransaction().commit();
			ss.close();
			return false;
		}	
		
	}

	@Override
	public boolean sentdelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		Mail_info dto=(Mail_info) cr.uniqueResult();
		boolean b=false;
		if(dto!=null) {
			dto.setStatus("sentdeleted");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			b= true;
		
	}
		return b;

	}

	@Override
	public boolean inboxdelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		Mail_info dto=(Mail_info) cr.uniqueResult();
		boolean b=false;
		if(dto!=null) {
			dto.setStatus("inboxdeleted");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			b= true;
		
	}
		return b;
	}

	@Override
	public boolean draftdelete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("Id", id));
		Mail_info dto=(Mail_info) cr.uniqueResult();
		boolean b=false;
		if(dto!=null) {
			dto.setStatus("draftdeleted");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			b= true;
		
	}
		return b;
	}
	
}


	
	
	
	
	
	
	

	

