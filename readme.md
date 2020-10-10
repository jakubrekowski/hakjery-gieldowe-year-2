# Hakjery Giełdowe

## Dokumentacja

### RSI
Klasa zwraca agenta RSI.

#### runRSI(isin) 
Zwraca odpowiedź agenta RSI spółki, której numer isin jest przekazany w argumencie.
```isin``` jest typu string.

Zwraca:
- ``-1`` Sprzedaj
- ``0`` Wstrzymaj się
- ``1`` Kup

### ReadData 
Klasa zwraca dane dla danej spółki.

#### getQuotation(isin)
Zwraca cenę akcji spółki na podstawie numeru isin przedsiębiorstwa.
```isin``` jest typu string.