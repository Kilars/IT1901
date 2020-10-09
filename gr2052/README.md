# Booking System
Denne appen er laget for at kunder enkelt skal kunne booke tilgjengelige tider i en frisørsalong. Brukeren skal kunne velge frisør, behandling, se et prisanslag, og avbestille bestillingen frem til et gitt tidspunkt før timen starter. Appen skal huske brukerinfo og historikk. <br />
Appen skal vise en oversikt over tilgjengelige behandlinger hvor brukeren kan krysse av for hva som ønskes. Deretter vises en oversikt over frisørene som tilbyr denne behandlingen (evt. disse behandlingene). Når frisør er valgt får man opp en oversikt over tilgjengelige datoer og klokkeslett. Brukeren må deretter bekrefte timen. Brukerhistorikken tar vare på tidigere og kommende avtaler hvor det også er mulig å avbestille.<br /> 

Eventuelle ekstrafunksjoner: rate frisør, klippekort/lojalitetsprogram, kunne legge inn fast bestilling med ønsket tidsrom, endre bestillingen uten å avbestille.<br />

## Illustrasjon av appen

<img src="Skjermbilde_2020-09-09_kl._12.14.44.png" alt="llustrasjon 1 - velge behandling" width="450"/>
<img src="Skjermbilde_2020-09-09_kl._12.14.51.png" alt="Illustrasjon 2- velge dato" width="450"/>


## Brukerhistorier:
Disse brukerhistoriene dekker vår plan for applikasjonen, og vil bli avkrysset etterhvert som arbeidet med dem starter. Vi vil prioritere kodekvalitet over hvor mange av funksjonene/brukerhistoriene som faktisk blir implementert. 
* [x] 1. Som en bruker ønsker jeg å registrere meg/logge inn slik at dataene mine blir lagret.
* [ ] 2. Som en bruker ønsker jeg å kunne velge den behandlingen jeg ønsker.
* [ ] 3. Som en bruker ønsker jeg å se mine kommende og tidligere avtaler.
* [ ] 4. Som en bruker ønsker jeg å kunne avbestille timen min.
* [ ] 5. Som en bruker ønsker jeg å velge mellom de frisørene som er tilgjengelige.
* [ ] 6. Som en bruker ønsker jeg å se tilgjengelige datoer og klokkeslett, og velge mellom disse. 
* [ ] 7. Som en bruker ønsker jeg å kunne se prisen på behandlingen(e) jeg velger.
* [x] 8. Som en bruker ønsker jeg et intuitivt og funskjonelt brukergrensesnitt, slik at applikasjonen er enkel og praktisk i bruk.
* [ ] 9. Som en bruker ønsker jeg å kun måtte lage bruker en gang for så å kunne logge inn med denne.

## Prosjektfremgang

### Oppstart og registrere bruker (uke 37 og 38)
Milestone: Innlevering 1 <br />
**Oppsett av prosjektet:** <br />
Issues: #1, #2, #3, #4, #5, #6, #7, #10 <br />
**Brukerhistorie 1:** <br />
"Brukeren har behov for å dele sin kontaktinformasjon med frisørsalongen, og det er praktisk at dette lagres. Dette gjøres ved at det er mulig å registrere en bruker. Når en ny bruker skal registrere seg må hen oppgi navn, epost-adresse og telefonnummer."<br />
 -Issues: #8, #9, #12, #13, #14, #15, #16 <br />
 **Brukerhistorie 8:** <br />
 "Som en bruker ønsker jeg et intuitivt og funskjonelt brukergrensesnitt, slik at applikasjonen er enkel og praktisk i bruk." <br />
 -Issues: #9, #11, #14, <br />
 <br />
 ### Dokumentasjon og JSON-implementasjon (uke 39)
 Milestone: Innlevering 2 <br />
 **Dokumentasjon:**<br />
 Kommentere koden fra forrige innlevering og oppdatere readme for å sikre god dokumentasjon.I tillegg skal diagram over arkitekturen legges til. <br />
 Issues: #17, #18, #19, #20, #21, #22 <br />
 **JSON-implementasjon:**<br />
 Implementere JSON- og Jackson-plugins og legge til rette for god, enkel og sikker fillagring.<br />
 -Issues: #28, #50, #60 <br />