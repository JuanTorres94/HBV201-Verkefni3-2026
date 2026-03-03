Verkefni 3 - Ferðaplan


Verkefnið sem á að leysa
Forrita á Ferðaplan þar sem notandi getur valið ferð af lista, séð nánari upplýsingar um ferðina í sama glugga og bætt við ferð með modal dialog. Notandi skal einnig geta eytt ferð (með staðfestingu í modal dialog). Forritið skal styðja skiptingu á milli viðmótstrjáa innan sama glugga.

Hver ferð skal innihalda a.m.k. eftirfarandi upplýsingar: heiti ferðar, áfangastað og dagsetningu.

Dæmablöð
Dæmablöð 6 (16.2), 7 (23.2) og 8 (2.3) fylgja verkefninu. Eftir hvert dæmablað ættirðu að hafa keyranlegt forrit

6 – Vinnsla + ViewSwitcher/View: setja upp grunninn og skipta á milli viðmótstrjáa í sama glugga (Skoða).

7 – Custom component: búa til sérhæfðan viðmótshlut (endurnýtanlegan) og bæta birtingu í Skoða.

8 – Dialogar: útfæra modal dialoga fyrir Bæta við og Eyða (með staðfestingu).


Hæfniviðmið (tilvísun í kaflaheiti á Canvas fylgir)
Að nemandi geti:

5.1 Viðmótstré og skipting milli þeirra
    forritað lestur nokkurra viðmótstrjáa (views) úr .fxml skrám
    forritað skiptingu á milli viðmótstrjáa í einum glugga (t.d. með ViewSwitcher / View)
    brotið notendaviðmót niður í margar .fxml skrár með tilheyrandi controllurum
    nemandi geti notað klasana ViewSwitcher og View til að stjórna flæði milli viðmóta

5.2 Dialog og gagnaflæði
    hannað notendaviðmót fyrir modal dialog
    forritað modal dialog í sér .fxml skrá
    forritað flæði gagna í og frá dialog (t.d. með showAndWait() og skilagildi)

5.3 Stöður og stöðuvél
    skissað/teiknað stöðurit sem sýnir flæði milli viðmótstrjáa og stöðuvél (state machine)
    forritað klasa eða enum sem útfærir mismunandi stöður
    tengt hegðun í notendaviðmóti við stöðu (t.d. enable/disable takka o.fl.)

6.1 ListView og gagnatenging
    tengt gögn við ListView (t.d. með ObservableList)
    forritað val á staki í ListView og uppfært viðmót út frá vali

6.2 Sérhæfður klasi (Custom Component)
    forritað sérhæfðan klasa (custom component)
    skrifað .fxml skrá fyrir sérhæfðan klasa
    notað sérhæfðan klasa í öðru viðmóti (.fxml eða ListView)

Gagnvirkniskröfur
Sjá skissu hér á eftir

Allt forritið er í einum glugga og svo dialog glugga. Þegar talað er um viðmót hér á eftir þá er verið að vísa í viðmótstré. Það eru tvö viðmótstré sem skipt er á milli í einum glugga: Aðal og Ferð.

Þegar notandi ræsir forritið kemur upp gluggi með Aðal viðmótinu. Þar birtist listi af ferðum. Í Aðal viðmótinu er hægt að:
Bæta við ferð,
Skoða ferð nánar, eða
Eyða ferð.
Skoða ferð: Ef notandi velur að skoða ferð opnast Ferð viðmótstré í sama glugga og nánari upplýsingar um valda ferð birtast.
Bæta við ferð: Ef notandi velur að bæta við ferð opnast modal dialog. Reitir eru þá tómir. Notandi fyllir út a.m.k. þrjá reiti: heiti ferðar, áfangastað og dagsetningu og staðfestir. Eftir staðfestingu lokar dialog og ný ferð er sýnileg í lista í Aðal viðmótinu.
Eyða ferð: Ef notandi velur að eyða valinni ferð birtist staðfesting í modal dialog. Ef notandi staðfestir er ferðinni eytt og dialog lokast.
Hnapparnir/Valið „Skoða“ og „Eyða“ skulu vera óvirkir (disable) þegar ekkert stak er valið í ListView.
(Valkvætt – gefur 0.5 / 10 stig) Í Aðal er möguleiki á að Breyta ferð. Þá opnast viðeigandi dialog með fyrirfram fylltum reitum. Notandi getur breytt upplýsingum og staðfest breytingar.
Útlitskröfur
Vandið hönnun útlitsins. Gætið t.d. að bili á milli viðmótshluta, stærð viðmótshluta og útliti.
Farið eftir hönnunarleiðbeiningum.
Forritunarkröfur
Hafið tvo yfir pakka (e. package)  is.vidmot og is.vinnsla . Það getur verið gagnlegt (en valkvætt) að hafa frekari skiptingu á is.vidmot, t.d.:
is.vidmot.switcher – fyrir ViewSwitcher og View
is.vidmot.controller – fyrir  controller-klasana
is.vidmot.view – fyrir custom component (t.d. FerdSpjald)
Notendaviðmótinu er lýst í eftirfarandi .fxml skrám: adal-view.fxml fyrir Aðal viðmótstré og ferd-view.fxml fyrir Ferð viðmótstré.
Bætið við .fxml skrá fyrir custom component, ferd-spjald.fxml, og samsvarandi klasa FerdSpjald. Componentinn skal notaður í viðmóti, t.d. sem cell í ListView eða sem endurnýtanlegur hlutur sem er notaður  í ferd-view.fxml og  ny-ferd-dialog.fxml.
Bætið við .fxml skrám fyrir modal dialoga:
4.1 ny-ferd-dialog.fxml (dialog með innsláttarreitum sem skilar gögnum). FerdDialogController er controllerinn fyrir DialogPane en FerdDialogWrapper er wrapper / factory klasi utan um dialoginn.
4.2 stadfestaEyda-view.fxml (staðfesting á eyðingu).
Staðfesting á eyðingu skal vera útfærð sem modal dialog. Dialogurinn skal vera skilgreindur í stadfestaEyda-view.fxml og sýndur með showAndWait().
Notið a.m.k. eftirfarandi controllera sem samsvara .fxml skránum: AdalController, FerdController, FerdDialogController og StadfestingEydaDialogController (heiti mega vera önnur en skulu vera skýr og samsvara .fxml skránum).
Notið View og ViewSwitcher til að skipta á milli viðmótstrjáa í sama glugga. Notið gefna klasa   og setjið í sér pakka ( is.vidmot.switcher). Sjá einnig GognInterface.java sem er Java Interface
Birtið ferðir í ListView hlut sem er tengt við ObservableList af ferðum.
Val á staki í ListView verðu til þess að notandi getur Skoðað valda ferð eða Eytt valinni ferð.
Notið properties, binding og listeners eins og við á, þannig að viðmót uppfærist út frá gögnum í vinnslu (forðist „bein köll“ sem uppfæra viðmót í mörgum stöðum án binding/listeners).
(Valkvætt – 0.5/10 stig bætist við) Útfærið „Breyta“ þannig að notandi geti opnað dialog með fyrirfram fylltum reitum, breytt og staðfest.
Notist við góðar forritunarvenjur: Hafið aðferðir stuttar og forðist endurtekinn kóða. Hjálparaðferðir eiga að vera private. Allar tilviksbreytur eiga að vera private og hafa get/set-aðferðir ef á þarf að halda. Hafið klasa með stórum upphafsstaf og breytur og aðferðir með litlum upphafsstaf.
Skjölun: Skjalið klasa, tilviksbreytur og aðferðir með JavaDoc. Notið checkstyle plugin til að athuga hvort snið og skjölun er rétt (sjá einnig leiðbeiningar á Canvas).

Annað til upplýsinga
Ef þið viljið að það birtist listi af 2-3 ferðum þegar forritið ræsist er nóg að harkóða það í Ferdaplan klasanum. Þið getið líka lesið úr .txt (s) skrá sem er undir resources svona
InputStream is = getClass().getResourceAsStream(s);
if (is !=null) {
    Scanner scanner = new Scanner(is, StandardCharsets.UTF_8);
    while (scanner.hasNextLine()) {
        String ferd = scanner.nextLine();
        // Búa til nýja ferð, f, með innlesinni línu, l, smiðurinn sér um að parse-a línu
        // bæta f við listann
}
}


Gagnleg dæmi
TakeAway, verkefni 3 síðan 2023 (HBV201G-verkefni á https://github.com/ Links to an external site. hvannberg)
úr Viku 5, m.a. DialogResultConverter, MultipleViews, DialogDemoPersonFXML
úr Viku 6, KennsluskraNamskeid og Serhaefdur (kisuforritið)

Námsmat
Það er gefin einkunn fyrir útlit,  gagnvirkni og forritun. Ef forrit þýðir (e. compile) ekki fæst ekkert fyrir gagnvirkni og forritun. Gætið þess að prófa forritið vel þannig að það krassi ekki.  Verkefnið er einstaklingsverkefni. Forritið það sjálf.
Drög að matksvarða er hér. Með fyrirvara um hugsanlegar breytingar.

Skila

Skilaðu í Gradescope. Sjáðu leiðbeiningar hér.

Listi af klösum
Klasarnir eru a.m.k. eftirfarandi Ef þið veljið að nota önnur klasanöfn, gerið tveggja dálka töflu í PDF skjalinu þar sem þið segið hvaða klasa þið notið í staðinn/til viðbótar

Ef þið veljið að nota önnur klasanöfn, gerið tveggja dálka töflu í PDF skjalinu þar sem þið segið hvaða klasa þið notið í staðinn/til viðbótar.

is.vidmot
FerdaplanApp

is.vidmot.controller
AdalController - controller fyrir aðalviðmótið

FerdController - controller fyrir að skoða ferð í glugga

GognInterface - interface Links to an external site.sem FerdController implements (útfærir)

FerdDialogWrapper - wrapper fyrir Dialog<Ferd>

FerdDialogController - controller fyrir DialogPane fyrir að bæta við ferð

StadfestingEydingDialogController - controller fyrir staðfestingardialog þegar ferð er eytt

is.vidmot.switcher
View - Gefið

ViewSwitcher - Gefið

is.vidmot.view
FerdSpjald (custom component) til að sýna Ferd, endurnýtt í öðrum viðmótstrjám

is.vinnsla
Ferd - klasi sem inniheldur eina ferð
Ferdaplan - klasi sem inniheldur lista af ferðum

resources/is.vidmot -
athugið að gefa slóðina í gera getResource("/is/vidmot/adal-view.fxml")
adal-view.fxml

ferd-view.fxml

ferd-spjald.fxml

ny-ferd-dialog.fxml

stadfestingEyda-dialog.fxml

undir /CSS í viðeigandi möppum

*.css að eigin vali

Skissur
Skissa af notendaviðmóti. Download Skissa af notendaviðmóti.

Skissa af stöðuriti  Download Skissa af stöðuriti

Skissa af Controllerum fyrir dæmablað 6 Download Skissa af Controllerum fyrir dæmablað 6
Klasar í vinnsluhluta Download Klasar í vinnsluhluta



Lausnin
Lausnin verður sett á Git geymslu (repository) HBV201G-Verkefni-2026 Links to an external site.
