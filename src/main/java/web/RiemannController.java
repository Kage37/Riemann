package web;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import riemann.*;

@Controller
public class RiemannController {

    @RequestMapping(path="/solve", method=RequestMethod.POST)
    @ResponseBody
    String solve(
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

	return "Solution: ["+solution+"]";
    }

}