package study.controller;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/email")
public class MailController {

    @Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier(value="mailSender")
    private JavaMailSender mailSender;


    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getMail(){
        return "emailForm";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request){

        // takes input from e-mail form
        String receipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // prints debug info
        System.out.println("To: " + receipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        // create a simple e-mail address
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(receipientAddress);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
        return "result";
    }
}
