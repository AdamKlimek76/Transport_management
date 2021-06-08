# Transport_management
System zarządzania transportem specjalistycznym

Opis:
System będzie mógł być wykorzystany w małej lub średniej firmie, zajmującej się transportem specjalistycznym tj. świadczącej usługi na rzecz niewielkiej liczby stałych podmiotów, realizujących dostawy na stałych lub rzadko zmienianych trasach oraz przewożących niewielką liczbę asortymentów.

Firmy realizujące dostawy w powyższy sposób otrzymują zlecenia poprzez np. kilka różnych portali internetowych danych firm lub drogą mailową. Bardzo uciążliwa – zwłaszcza dla szefostwa jest ciągła obserwacja różnych platform (i nie tylko) oraz analiza wykonywanych zleceń pod kątem np. ich opłacalności, gdzie trzeba łączyć różne dane z różnych źródeł.

System ma umożliwić zarządzanie i analizę danych z jednego miejsca i w jednolity sposób.

Sposób działania systemu:

1.	Dział logistyki otrzymuje zlecenia poprzez portal klienta – zlecenia są eksportowane do pliku przejściowego np. *.xls lub *.txt i importowane do nowego systemu. System sprawdza czy nie ma już taki zleceń, oraz czy miejsca załadunku, rozładunku itp. są już zdefiniowane w systemie.
2.	Dział logistyki otrzymuje zlecenia drogą mailową – wprowadza zlecenia ręcznie do systemu.
3.	Po wprowadzeniu zleceń do systemu podpinane są z innych tabel – kilometry, średni czas przejazdu, koszty drogowe itp. 
4.	Dział logistyki przypisuje do transportu ciągnik, naczepę, kierowcę, datę i godzinę załadunku. Uzupełniane są szacowane koszty paliwa, dokonuje się analiza możliwości realizacji danego zlecenia pod kątem terminowości oraz przepisów dotyczących czasu pracy kierowców. Będzie rozróżnienie na transport własny i podwykonawców.
5.	Po dokonaniu awizacji dyspozytor ma możliwość z poziomu systemu wysłania zlecenia do kierowcy za pośrednictwem sms w różnych trybach np. kilku zleceń do przodu, zleceń w których opis tras stałych będzie sformułowany w sposób skrótowy lub szczegółowy lub będzie dokonywana zmiana zleceń.
6.	Treść smsów będzie zapisywana albo w bazie danych albo w plikach np. txt???
7.	Kierownictwo będzie miało możliwość analizy koszty po wcześniejszym uzupełnieniu dodatkowych danych – stałych kosztów leasingu, kredytów, podatków, ubezpieczeń – przypisanych do danego środka transportu. Będzie trzeba uzupełniać również koszty związane z wynagrodzeniem kierowców oraz koszty zmienne przypisane do poszczególnych środków transportu np. koszty napraw, serwisów itd.
8.	Pracownicy działu logistyki będą wpisywać również do systemu faktury – głównie pod kątem terminów płatności – będą również dekretowane koszty.
9.	Kierownictwo będzie miało możliwość analizy: miesięcznych przychodów, dochodowość poszczególnych tras, miesięczną dochodowość poszczególnych środków transportu oraz kierowców oraz analizę przejechanych przez nich kilometrów oraz wiele innych wymaganych zestawień.
10.	System będzie dawał możliwość sortowania i filtrowania po poszczególnych kolumnach.
11.	System będzie miał możliwość eksportu zestawień do plików *.txt lub *.xls


Użytkownicy:

Przewidywane są dwa typy użytkowników:

1.	User pod adresem /user – z ograniczonym dostępem do danych (np. pracownicy działu logistyki)
2.	Admin pod adresem /admin – z pełnym dostępem do danych (kierownictwo, właściciel)


Tabele:

1.	Użytkownicy (login, hasło, imię,  nazwisko, stanowisko,  typ użytkownika)
2.	Ciągniki (nr rejestracyjny, marka, rok produkcji, ref koszty stałe, średnie spalanie)
3.	Naczepy (nr rejestracyjny, marka, rok produkcji, typ naczepy, ref koszty stałe)
4.	Kierowcy (imię, nazwisko, nr telefonu, wynagrodzenie)
5.	Przewożony towar (nazwa)
6.	Miejsce załadunku (firma, kod pocztowy, poczta, miejscowość, kraj, alias-skrót)
7.	Miejsce rozładunku(firma, kod pocztowy, poczta, miejscowość, kraj, alias-skrót)
8.	Status(status realizacji zlecenia)
9.	Zlecenie(ref miejsce załadunku, ref miejsce rozładunku, data załadunku, godzina załadunku, data rozładunku, godzina rozładunku, ref przewożony towar, ref kierowca, ref ciągnik, ref naczepa, ref status, czy spóźnienie, czy przekroczony czas pracy kierowcy)
10.	Trasy(ref miejsce załadunku, ref miejsce rozładunku, km, czas przejazdu, koszty viatoll
11.	Wynagrodzenie(wynagrodzenie brutto, całkowity koszt wynagrodzenia dla pracodawcy)
12.	Aktualne wynagrodzenie(data od kiedy, ref kierowca, ref wynagrodzenie)
13.	Koszty stałe (ref tytuł, opis, kwota netto, brutto, od kiedy, do kiedy)
14.	Koszty zmienne ciągnik(ref tytuł, opis, kwota netto, brutto, data, ref ciągnik)
15.	Koszty zmienne naczepa(ref tytuł, opis, kwota netto, brutto, data, ref naczepa)
16.	Smsy (data, godzina, treść – „nr telefonu, imię kierowcy, nazwisko kierowcy, treść smsa”)
17.	Średnia cena paliwa (tylko do celów zestawień kosztów)(cena netto, cena brutto, od kiedy)

Zestawienie nie będą zapisywane w tablicach, będzie można je eksportować do plików.

