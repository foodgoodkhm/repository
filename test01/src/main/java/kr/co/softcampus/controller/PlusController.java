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

@Controller // ���� ���� ������! �̰� �ٿ��� ComponentScan�� ���� ��ϵȴ�
public class PlusController {
    @RequestMapping(path="/plusform", method=RequestMethod.GET) // "/plusform" ��ο� GET �޼���� ��û���� ���
    public String plusform() {
        // view �̸��� �����Ѵ�.
        // �Ʊ� �츮�� ViewResolver�� ���� �� prefix�� suffix�� �����߾���.
        // ���� ���������δ� "/WEB-INF/views/plusForm.jsp"�� �����ش�.
        return "plusForm";
    }
    
    @RequestMapping(path="/plus", method=RequestMethod.POST)
    public String plus(@RequestParam(name="value1", required=true) int value1,
            @RequestParam(name="value2", required=true) int value2, ModelMap modelMap) {
        int result = value1 + value2;
        
        // ModelMap�� ����� attribute�� jsp������ request scope attribute�� �ڵ� ��ϵȴ�.
        modelMap.addAttribute("value1", value1);
        modelMap.addAttribute("value2", value2);
        modelMap.addAttribute("result", result);

        // view �̸� ����
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
