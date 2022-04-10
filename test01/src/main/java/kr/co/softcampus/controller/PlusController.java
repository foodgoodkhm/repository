package kr.co.softcampus.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller // 잊지 말고 붙이자! 이걸 붙여야 ComponentScan을 통해 등록된다
public class PlusController {
    @RequestMapping(path="/plusform", method=RequestMethod.GET) // "/plusform" 경로에 GET 메서드로 요청받은 경우
    public String plusform() {
        // view 이름을 리턴한다.
        // 아까 우리가 ViewResolver를 만들 때 prefix와 suffix를 설정했었다.
        // 따라서 최종적으로는 "/WEB-INF/views/plusForm.jsp"를 보여준다.
        return "plusForm";
    }
    
    @RequestMapping(path="/plus", method=RequestMethod.POST)
    public String plus(@RequestParam(name="value1", required=true) int value1,
            @RequestParam(name="value2", required=true) int value2, ModelMap modelMap) {
        int result = value1 + value2;
        
        // ModelMap에 등록한 attribute가 jsp에서는 request scope attribute로 자동 등록된다.
        modelMap.addAttribute("value1", value1);
        modelMap.addAttribute("value2", value2);
        modelMap.addAttribute("result", result);

        // view 이름 리턴
        return "plusResult";
    }
    
    @RequestMapping("/upload")
	public String upload(@RequestParam("article_file") List<MultipartFile> files, @RequestParam("article_file2") List<String> seq) throws Exception {
		
    	Map<Object, String> map = new HashMap<Object, String>();
		
    	for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i).getOriginalFilename());
		}
    	for (int i = 0; i < seq.size(); i++) {
			System.out.println(seq.get(i).toString());
		}
    	
		return "map";
	}
}
