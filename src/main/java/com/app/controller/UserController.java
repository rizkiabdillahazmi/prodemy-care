package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Donation;
import com.app.model.Event;
import com.app.model.ListDonatur;
import com.app.model.Payment;
import com.app.service.DonationService;
import com.app.service.DonaturService;
import com.app.service.EventService;
import com.app.service.PaymentService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private DonationService donationService;
	
	@Autowired
    private PaymentService paymentService;
	
	@Autowired
    private EventService eventService;
	
	@Autowired
    private DonaturService donaturService;
	
	@GetMapping("/")
	public String user1(Model model) {
		model.addAttribute("user","tes");
		return "user/index";
	}
	
	@GetMapping("/donasi")
	public String listAjuan(Model model) throws Exception {
		List<Donation> listDonasi = donationService.findAll();
		model.addAttribute("listDonasi",listDonasi);
		
		List<ListDonatur> listDonatur = donaturService.findAll();
        model.addAttribute("listDonatur",listDonatur);
		return "user/donasi";
	}
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    private java.util.Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
	
	@GetMapping("/donasiEdit")
	public String editAjuan(@RequestParam Long id, Model model) throws Exception {
		Donation ajuan = donationService.findById(id);
		model.addAttribute("cobalagi",ajuan);
		return "user/donasiEdit";
	}
	
	@PostMapping("/donasiUpdate/{id}")
	public String saveAjuan(Model model, HttpServletRequest req, @RequestParam Long id) throws Exception {
		Event event = new Event();
		event.setId(Long.parseLong(req.getParameter("eventId")));
		
		Payment payment = new Payment();
		payment.setId(Integer.parseInt(req.getParameter("payment")));
	    
	    Donation dnt = donationService.findById(id);
		dnt.setTitle(req.getParameter("title"));
		dnt.setTarget(Long.parseLong(req.getParameter("target")));
		dnt.setStatus(0);
		dnt.setPhoto(req.getParameter("photo"));
//		dnt.setEventId(Long.parseLong(req.getParameter("eventId")));
		dnt.setEvent(event);
//		dnt.setPayment(req.getParameter("payment"));
		dnt.setPayment(payment);
		dnt.setDeadline(parseDate(req.getParameter("deadline")));
		donationService.update(dnt);
		
		return "redirect:/user/donasi";
	}
	
	@GetMapping("/donasiTambah")
	public String viewAddAjuan(Model model) throws Exception {
	    model.addAttribute("metaTitle", "Pengajuan Donasi - ProdemyCare");
	    List <Payment> payment = paymentService.findAll();
        model.addAttribute("listPayment", payment);
        List <Event> event = eventService.findAll();
        model.addAttribute("listEvent", event);
		return "user/donasiTambah";
	}
	
	@PostMapping("/donasiTambah")
	public String addDonasiAjuan(Model model, HttpServletRequest req) throws Exception {
	    Event event = new Event();
	    event.setId(Long.parseLong(req.getParameter("eventId")));
	    Payment payment = new Payment();
        payment.setId(Integer.parseInt(req.getParameter("payment")));
        
		Donation dnt = new Donation();
		dnt.setTitle(req.getParameter("title"));
		dnt.setTarget(Long.parseLong(req.getParameter("target")));
		dnt.setStatus(0);
		dnt.setPhoto(req.getParameter("photo"));
//		dnt.setEventId(Long.parseLong(req.getParameter("eventId")));
		dnt.setEvent(event);
//		dnt.setPayment(req.getParameter("payment"));
		dnt.setPayment(payment);
		dnt.setDeadline(parseDate(req.getParameter("deadline")));
		donationService.save(dnt);
		
		return "redirect:/user/donasi";
	}
}
