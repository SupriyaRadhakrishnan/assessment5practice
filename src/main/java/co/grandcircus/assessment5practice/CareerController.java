package co.grandcircus.assessment5practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CareerController {
	
	@RequestMapping("/")
	public String yearSelection()
	{
		return "year-selection";
	}

	@RequestMapping("/submit-details")
	public String submitDetails(@RequestParam String name,@RequestParam int year,Model model)
	{
		
		if(!Character.isUpperCase(name.charAt(0)))
		{
			model.addAttribute("message","your name does not follow guidelines");
			return "sorry";
		}
		else if(year<1943)
				{
				model.addAttribute("message","birth year is out of range");
				return "sorry";
				}
		else if(year>2003)
				{
				model.addAttribute("message","you're too young");
				return "sorry";
				}
		
		else
		{
			model.addAttribute("name",name);
			model.addAttribute("year",year);
			return "career-selection";
			
		}	
	}
	
	@GetMapping("/career")
	public String careerDisplay(@RequestParam("name") String option,Model model)
	{
		System.out.println(option);
		model.addAttribute("option",option);
		return "career-display";
	}

}
