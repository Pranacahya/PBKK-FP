package com.PBKK.SIPTC.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.PBKK.SIPTC.entity.Transaksi;

@Repository	
public class TransaksiDAOImpl implements TransaksiDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Transaksi.class)
			.buildSessionFactory();
	Session currentSession = factory.getCurrentSession();
	
	@Override
	@Transactional
	public List<Transaksi> getAllTransaksi() {
		
		List<Transaksi> trans;
		System.out.println("my session is "+currentSession.getTransaction().isActive());
		System.out.println("commited");
		
		currentSession.beginTransaction();
		trans = currentSession
				.createQuery("from Transaksi", Transaksi.class)
				.getResultList();
		System.out.println(trans);
		
		currentSession.close();
		return trans;
	}


	@Override
	public void pushTransaksi(String user,
			String nrp,
			MultipartFile file,
			String copies, 
			String pages, 
			String color,
			String paper,
			String side,
			String note) {
		String myPath = System.getProperty("user.dir")+"/upload";
		if(pages.length() <= 3)
		{
			pages = "full-pages";
		}
		else
		{
			pages = pages.replace("on,","");
		}
		if(copies.length()==0)
		{
			copies = "1";
		}
		System.out.println(file);
		System.out.println(copies);
		System.out.println(pages);
		System.out.println(color);
		System.out.println(paper);
		System.out.println(side);
		System.out.println(note);
		String notes = copies +"| "+ pages+"| "+color +"| "+paper+"| " +side +"| " + note;
		File dirPath = new File(myPath);
		if (!dirPath.exists()) 
		{
	        dirPath.mkdirs();     
		}
		String myFile = dirPath+"/"+file.getOriginalFilename();
		System.out.println(myFile);
		File filePath = new File(myFile);
		try {
			file.transferTo(filePath);
			System.out.println("transfered");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String timeStamp[];
		timeStamp = dateFormat.format(date).split(" ");
		String tanggal = timeStamp[0];
		String time = timeStamp[1];
//		System.out.println(file); //2016/11/16 12:08:43
		
		
		// Begin Transaction
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// Create object
		Transaksi trans = new Transaksi(tanggal,time,user,nrp,notes,myFile.toString(),0);
				
		// Save object to database 
		session.save(trans);
		
		//Read data
		Transaksi tempTrans = session.get(Transaksi.class, trans.getId());
		System.out.println(tempTrans.getId());
		
		// Commit transaction
		session.getTransaction().commit();
		System.out.println("Committing transaction.");
				
		// Close transaction
		session.close();
		System.out.println("Session closed.");
		
	}

	@Override
	@Transactional
	public void deleteTransaksi(int id) {
		
		currentSession.beginTransaction();
		Query query = currentSession
				.createQuery("delete from Transaksi where id_transaksi=:id", Transaksi.class);
		query.setParameter("id", id);
		query.executeUpdate();
		
		currentSession.close();
	}

	@Override
	public Transaksi getTransaksi(int id) {
		
		currentSession.beginTransaction();
		Transaksi transaksi = currentSession.get(Transaksi.class, id);
		currentSession.close();
		return transaksi;
	}


	@Override
	public void updateTransaksi(Transaksi transaksi) {
		
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(transaksi);
		currentSession.close();
	}
}