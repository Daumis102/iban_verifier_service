## Intro
Šis projektas yra papildoma IBAN kodų tikrinimo užduotis - Servisas, kuris validuoja IBAN sąrašą.

Pastebėjau, jog Swedbank naudoja Spring framework ir nusprendžiau, jog Service kūrimas naudojant būtent Spring būtų įdomus iššūkis pačiam sau. Tad šis projektas naudoja Spring framework.

## Paleidimas:
Šis service paleidžiamas naudojant `gradlew bootRun` komandą.

## Naudojimas:
Kol Service yra paleistas, jis priima `POST` užklausas į `localhost:8000/verification` adresą ir patikrina kartu JSON formatu siunčiamų IBAN numerių sąrašą.

Pavyzdžiui, tai galima padaryti naudojant terminalą:
```
 curl -i \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
-X POST --data \
  '["AA051245445454552117989", "LT647044001231465456", "LT517044077788877777", "LT227044077788877777", "CC051245445454552117989"]' "http://localhost:8080/verification"
```

Gautas atsakymas grąžina JSON formato atsakymą: 
```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Fri, 30 Jul 2021 16:16:29 GMT

[{"valid":false,"iban":"AA051245445454552117989"},{"valid":true,"iban":"LT647044001231465456"},{"valid":true,"iban":"LT517044077788877777"},{"valid":false,"iban":"LT227044077788877777"},{"valid":false,"iban":"CC051245445454552117989"}]
```

## Detalės:
Šis projektas naudoja tą patį IBAN verifier, kuris buvo naudojamas IBAN tikrinimui lokaliai: https://github.com/Daumis102/iban_verifier, tačiau leidžia jį naudoti kaip REST API.
