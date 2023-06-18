package com.cydeo.lab08rest.client;

import com.cydeo.lab08rest.dto.CurrencyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "http://apilayer.net/api", name = "CURRENCY-CLIENT")
public interface CurrencyApiClient {
    // http://apilayer.net/api/live?access_key=bbdab96141ebb431f0ccfabada99a5d2&currencies=EUR,GBP,CAD,PLN&source=USD&format=1

    @GetMapping("/live")
    CurrencyApiResponse retrieveCurrency(@RequestParam(value = "access_key") String key,
                                         @RequestParam(value = "currencies") String currency,
                                         @RequestParam(value = "source") String source,
                                         @RequestParam(value = "format") int format);
//    Map<String,Object> getCurrencyRates(@RequestParam("access_key") String accessKey,
//                                        @RequestParam("currencies") String currencies,
//                                        @RequestParam("source") String source,
//                                        @RequestParam("format") int format);
    // the other option is we can use Object in general so that we do not need to custom DTO(CurrencyAPIResponse). We can use the details in the OrderService impl
}
