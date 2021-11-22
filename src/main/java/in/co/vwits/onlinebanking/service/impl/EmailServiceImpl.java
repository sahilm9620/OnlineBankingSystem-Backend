package in.co.vwits.onlinebanking.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import in.co.vwits.onlinebanking.service.EmailService;

@CrossOrigin
@Service
public class EmailServiceImpl implements EmailService {

	final Configuration configuration;
	final JavaMailSender javaMailSender;

	public EmailServiceImpl(Configuration configuration, JavaMailSender javaMailSender) {
		this.configuration = configuration;
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(Object user, String templateName, String title, String email)
			throws MessagingException, IOException, TemplateException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject(title);
		helper.setTo(email);
		String emailContent = getEmailContent(user, templateName);
		helper.setText(emailContent, true);
		javaMailSender.send(mimeMessage);
	}

	@Override
	public String getEmailContent(Object user, String templateName) throws IOException, TemplateException {
		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();
		model.put("user", user);
		configuration.getTemplate(templateName).process(model, stringWriter);

		return stringWriter.getBuffer().toString();
	}
}