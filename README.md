# Semesteroppgave 2: Othello

### Bekreft at du har lest viktig informasjon

Les [praktiskinfo.md](information/praktiskinfo.md) og åpne java filen `inf101.GetStarted.java` for å bekrefte at du har lest informasjonen. JUnit testene vil ikke virke før du har gjort dette.

`add-commit-push`


**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via ditt private gitlab-repositorie til **Fredag 30. april kl. 16:00**.  

### Innlevering 
 Du finner koden din i repositoriet ved å følge linken på denne siden:
 [https://git.app.uib.no/ii/inf101/21v/assignments](https://git.app.uib.no/ii/inf101/21v/assignments)

Oppgaven leveres inn ved å pushe til git.app.uib.no, slik du har gjort med alle tidligere INF101-oppgaver. Husk å få med alle nye filer du har opprettet.

**VIKTIG:** *Sjekk serveren og kommentaren etter at du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller flere ganger hver dag, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 15. 


## Oversikt
De to spillene "Tic Tac Toe" og "Connect Four" er allerede ferdig implementert.
Denne semesteroppgaven har 2 hoveddeler:
- Teori, sett deg inn i den eksisterende koden
- Utvid funksjonaliteten ved å legge til et tredje spill som heter [Othello](https://no.wikipedia.org/wiki/Othello_(brettspill)).
Reglene for spillet er ganske enkle men vær sikker på at du forstår reglene rett ellers kan det bli mye ekstra arbeid.

Læringsmål:
- sette seg inn i eksisterende kode
- forstå hva oppgaven ber om, (lese seg opp på reglene for spillet)
- planlegge kodeprosjekt, design av klasser og avhengighet mellom disse
- bruke objektorienterte prinsipper som polymorfisme, arv og abstrakte klasser
- ryddig og lesbar kodestil som gjør vedlikehold/utvidelse av koden enklere.

Et klassediagram over klassene i dette prosjektet finner dere på Mitt UiB.

Pakken grid - Så å si identisk til den som ble brukt i Semesteroppgave 1.

Pakken player - Flere typer Player objekter er implementert GuiPlayer, ConsolePlayer, MiniMaxPlayer DumbPlayer og RandomPlayer. 
Alle disse Spillerene kan brukes på begge spillene (og potensielt flere spill).

Pakken game kjører spillet ved en "game loop" og ber de forskjellige spillerne om input.
Hvilke type spiller og hvilken type grafikk det er skal ikke være viktig, man kan bytte ut begge deler.

Pakken GUI - det som trengs for å få grafisk brukergrensesnitt (untatt GuiPlayer)

Pakken Terminal - det som trengs for å spille fra terminal (untatt ConsolePlayer)

### Bruk
Sipllet kan kjøres på to måter: 

-inf101.sem2.MainTerminal - Kjører spillet via terminalen. 
-inf101.sem2.MainGUI - Kjører spillet med grafisk brukergrensesnitt. 


## Oppgave 1 - Designanalyse
I denne semesteroppgaven har vi allerede laget et fungerende spill for dere.
Dere skal kjøre spillet, se på klassediagrammet og se på koden slik at dere forstår hvordan koden fungerer.
Vi har allerede brukt noen forelesninger på å forstå hvordan denne koden fungerer.
Pakken gui er litt vanskelig å forstå og ikke en viktig del av programmet, de viktigste pakkene å forstå er grid, game og player.

Skriv en analyse av designet som er valgt for den eksisterende koden i prosjektet. Fokuser på hvilke objektorienterte prinsipper som er brukt. Hvis du ser mulige forbedringer er det veldig positivt om du skriver om dette. Svar på følgende spørsmål:

- Nevn noen viktige klasser og hvorfor vi trenger disse klassene?
- Hvor brukes abstraction, encapsulation, inheritance og polymorphism.
- Hvilke andre spill (eller utvidelser) vil det være enkelt å legge til i dette prosjektet, og hvilke spill vil by på utfordringer?
- Hvor er [SOLID](https://en.wikipedia.org/wiki/SOLID) prinsippene brukt/ikke brukt.
Merk at SOLID prinsippene ikke er pensum før i INF112 så vi forventer ikke så mye av dere her,
men de av dere som ønsker å få 15/15 må vise at dere har prøvd litt på dette.

## Oppgave 2 - Plan og klassediagram

Skriv en kort plan for hva du må gjøre for å implementere spillert Othello.
Her bør du skrive opp de klassene du trenger å lage og hvorfor.
Tegn et klassediagram, dere skal få utlevert et klassediagram av den eksisterende koden hvor dere kan legge til de nye klassene.

Dere kan godt gå tilbake til planen og gjøre endringer hvis dere oppdager at det trengs.
Men det kan være en fordel om dere lager en ordentlig plan før dere begynner slik at dere ikke gjør mer koding enn nødvendig.

## Oppgave 3 - Implementer Othello
Utvid funksjonaliteten til prosjektet slik at det også går an å spille Othello.
Spillet skal kunne spilles både fra terminal og fra GUI med flere valg av spillere.

Lesbar kode og gjenbruk av kode er viktig. 

Dere skal teste koden dere skriver. Den koden som er lett å teste med JUnit tester skal dere skrive tester for. Den delen av koden som er vanskelig å teste med JUnit tester skal dere beskrive tester der dere kjører spillet og sjekker at det virker som det skal.

Om dere finner feil i eksisterende kode så rapporterer dere det i svar.md filen.