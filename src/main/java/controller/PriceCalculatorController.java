package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookBasketRequest;
import com.example.demo.model.BookPriceResponse;
import com.example.demo.service.PriceCalculatorService;

@RestController
@RequestMapping("/api/books")
public class PriceCalculatorController {
	 @Autowired
	    private PriceCalculatorService priceCalculatorService;

	    @PostMapping("/calculate-price")
	    public ResponseEntity<BookPriceResponse> calculatePrice(@RequestBody BookBasketRequest request) {
	        var total = priceCalculatorService.calculatePrice(request.getBooks());
	        return ResponseEntity.ok(new BookPriceResponse(total));
	    }

}
