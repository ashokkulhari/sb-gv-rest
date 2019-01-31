package com.mc.controller

import java.util.List
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.github.alexanderwe.bananaj.connection.MailChimpConnection
import com.github.alexanderwe.bananaj.model.campaign.Campaign



@RestController
@RequestMapping('campaigns')
class MailChimpController {
  

	 String GET_LIST_URL_PRE = 'https://'
	String GET_LIST_URL_MIDDLE = '.api.mailchimp.com/3.0/campaigns/'
	 
	 @Value('${mailchimp_key}')
	 String apiKey
	
  @GetMapping('')
  String findAll() {
  print('findall...')
   MailChimpConnection con = new MailChimpConnection(apiKey)
		  List<Campaign> allLists
			
		try {
			 allLists = con.getCampaigns()
			for (int k = 0; k < allLists.size(); k++) {
				Campaign campaign = allLists.get(k)
				print("=============mailChimpList=============="+campaign.getContent() +""+campaign.toString())

				}
		} catch (Exception e) {
			e.printStackTrace()
		}
		
   'success'
  }

  
}
