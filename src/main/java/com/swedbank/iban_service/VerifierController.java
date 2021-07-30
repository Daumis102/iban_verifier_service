package com.swedbank.iban_service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class VerifierController {

	@PostMapping("/verification")
	public ArrayList<IbanInfo> verifyIbans(@RequestBody ArrayList <String> ibansToCheck) {

        IBANVerifier verifier = new IBANVerifier();
        ArrayList <IbanInfo> ibans= new ArrayList<>();
        for(String ibanToCheck : ibansToCheck){

            IBAN iban = new IBAN(ibanToCheck);

            IbanInfo ibanInfo = new IbanInfo(ibanToCheck, verifier.isValid(iban));
            ibans.add(ibanInfo);
        }

		return ibans;
	}
}