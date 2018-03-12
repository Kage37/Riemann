package web;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import riemann.*;

@Controller
public class RiemannController {

    @RequestMapping(path="/solve", method=RequestMethod.POST)
    String solve(
        Model model,
    	@RequestParam String equation, 
    	@RequestParam int where, 
    	@RequestParam double leftBound, 
    	@RequestParam double rightBound,
    	@RequestParam int rectangles){

    	EquationData data = new EquationData(
    		equation,
    		where,
    		leftBound,
    		rightBound,
    		rectangles);

    	Riemann solver = new Riemann();
    	double solution = solver.getSum(data);

        model.addAttribute("data", data);
        model.addAttribute("solution", solution);

	return "result";
    }

}