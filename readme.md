[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.idi.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2020/gr2052/gr2052) 


# Booking System - Oversikt og Struktur

Dette prosjektet har to moduler, en for core og en for fxui. Inne i core finner man domenelag og persistenslag. I fxui finner man brukergrensesnittlaget. Disse tre lagene gjør at vi har en trelagsapplikasjon.  Prosjektet er konfigurert med **maven** som byggesystem.

Mappen **[gr2052](gr2052)** utgjør kodingsprosjektet. Her finner du en **[readme-fil](gr2052/README.md)** som beskriver plan for selve prosjektet og fremgang nærmere.

## Organisering av koden

Hvert lag har 4 kildekodemapper, kode og ressurser for henholdsvis applikasjonen selv og testene:

- **src/main/java** for koden til applikasjonen
- **src/main/resources** for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av applikasjonen.
- **src/test/java** for testkoden
- **src/test/resources** for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av testene.

## Bygging og kjøring av prosjektet

Prosjektet bruker maven til bygging og kjøring. `mvn install` må kjøres fra rot-prosjektet før appen kan kjøres. Denne kjører automatisk alle tester og kvalitetssjekker.  
Selve prosjektet (applikasjonen) må kjøres fra fxui-modulen, enten med `mvn javafx:run -f fxui/pom.xml` eller ved å først kjøre `cd fxui` og så `mvn javafx:run`.


## Domenelaget

Domenelaget inneholder alle klasser og logikk knyttet til dataene som applikasjonen handler om og håndterer, og disse finnes i **[bsystem.core](gr2052/core/src/main/java/bookingsystem/core)**-pakken.
Vår app handler om å kunne registrere seg som bruker i et bookingsystem for frisørsalong for så å booke timeavtale med en frisør for å få en gitt behandling. 

## Brukergrensesnittlaget

Brukergrensesnittlaget inneholder alle klasser og logikk knyttet til visning og handlinger på dataene i domenelaget. Brukergrensesnittet til vår app inneholder per nå registrering av bruker, innlogging, brukerprofilside og side for å booke ny time. 

Brukergrensesnittet er laget med JavaFX og FXML og finnes i **[bsystem.ui](gr2052/fxui/src/main/)**-pakken (JavaFX-koden i **gr2052/fxui/src/main/java** og FXML-filen i **gr2052/fxui/src/main/resources**)

## Persistenslaget

Persistenslaget inneholder alle klasser og logikk for lagring (skriving og lesing) av dataene i domenelaget. Vårt persistenslag implementerer fillagring med JSON-syntaks og finnes i **[bsystem.json](gr2052/core/src/main/java/bookingsystem/json/)**-pakken.

## maven

Vårt bygg har tillegg for:

- oppsett av java (**maven-compiler-plugin**)
- testing (**maven-surefire-plugin**)
- kjøring av javafx (**javafx-maven-plugin**)
- sjekking av kodekvalitet med [checkstyle](https://checkstyle.sourceforge.io) (**maven-checkstyle-plugin**) og [spotbugs](https://spotbugs.github.io) (**spotbugs-maven-plugin**)
- testdekningsgrad med [jacoco](https://github.com/jacoco/jacoco) (**jacoco-maven-plugin**)

## Foreløpig klassediagram
Viser enveisassosiasjonen fra Users til User og FilesHandle

<img src=http://www.plantuml.com/plantuml/png/TPFDRXCn4CVlVeev1kY-G1LLLQL6L224511d4qytLls1FBDPAjHtPsUzCZQxkJZs_pUPxxqdrea7xvHYomxX8SON6teulXAZXmu-EKs4nke-QQ-KEiaRlXCcWZyAeFjiYU673IQEj1Vz3eRf55dmmJgaZpeOX_0ytVCr2Jfoab2YVj4U9-d39Le3Bcep1pYawEN_kspvhbYGlk1iyIrkScsCu9qS_zI4Fbwm0PrSe4UMtyfDzpD6Xph0wOodbwTdmO-_BJ4LexUw5tChfZYbf4GiDJKg3Idyhw7NrZNAhtCCs2gQQ8p9P34t0FdhefQ4MYfUjj5XIUuAFkOij-6Zf5kZaYJ7VDcrSb_5MwCSQmrod9MSgrhBfHMPjCDhAdrRPbPjPPvSLthDvwhaCLd6PibkG3PxdnztDx34MdAg6IJKPht2nRT1XpoluyFhaodkhncsNjfDuFFcJFg5pSkQFzbzP-8OEf3NBGoYtSBx5jRT0QNkCPZ1kxy0>

