# DA-automatizovane_testy-ukol
Automatické testy - Domácí úkol
Po třetí lekci následuje domácí úkol:
Bude třeba napsat několik automatizovaných testů reálné aplikace, se kterou jste se už setkali:
https://cz-test-jedna.herokuapp.com/

Zadání
Vytvořte automatizované testy:

Rodič s existujícím účtem se musí být schopen přihlásit do webové aplikace.

Poznámka: Nepište automatizovaný test na zakládání nového účtu rodiče. Účet si připravte dopředu ručně nebo použijte svůj již existující z kurzu manuálního testování.

Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz.

Varianta, že rodič nejprve vybere kurz a potom se přihlásí ke svému účtu, vyplní přihlášku, odešle ji a nakonec ve svém seznamu přihlášek zkontroluje, že ji systém eviduje.

Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz.

Varianta, že se rodič nejprve přihlásí ke svému účtu a potom vybere kurz, vyplní, odešle, zkontroluje v seznamu.

Jeden další scénář dle své úvahy.

Tipy
Webová appka není uplně přátelská k automatizovaným testům. Hodně elementů bude třeba vyhledávat podle textu, protože jinak nejsou ničím odlišitelné od ostatních elementů. S tím se ale v realitě běžně potkáte. V dlouhodobém horizontu je vhodné požádat vývojáře o přídaní atributu id nebo class k vámi požadovaným elementům, v krátkodobém horizontu je ale potřeba se s tím smířit.

Obecně vyhledávání elementů podle textů je nevhodné kvůli budoucím překladům webu do jiného jazyka nebo budoucím změnám textace. Z krátkodobého hlediska to ale zas takový problém není.

Někdy se může stát, že stejné tlačítko se stejným textem je na stránce vícekrát a vy si chcete vybrat například 3. výskyt. V takových případech je možné to udělat pomocí sofistikovaného dotazu XPath, nebo v Javě dvoukrokově.

Například: Chcete kliknout na odkaz Více informací v obdelníčku 3. kurzu. Pokud je tedy element tlačítka například <a>, přesněji <div class="card">...<a>Více informací</a>...</div>, můžete zkusit toto:

XPath:
( //div[@class = 'card'] )[3]//a[text()='Více informací']
Java:
Nejprve vybrat pomocí findElements() všechny výskyty, a potom si ze seznamu (List<WebElement>) vybrat jen ten 1 element, na který jste mířili.

List<WebElement> seznamTlacitekViceInformaciVsechKurzu =
        prohlizec.findElements(By.xpath(
                "//div[@class = 'card']//a[text() = 'Více informací']"
        ));
WebElement tretiTlacitkoViceInformaci = seznamTlacitekViceInformaciVsechKurzu.get(2);
tretiTlacitkoViceInformaci.click();
Rozklikávací menu s termíny kurzů lze vyplnit například tak, že kliknete do <div>Vyberte termín...</div> a potom začnete psát do <div class="bs-searchbox">…<input type="search">…</div> prvních pár číslic z datumu. Až to omezíte na jedinou možnost, stisknete Enter.

Pokud chcete stisknout v textovém políčku klávesu Enter (zvolit aktuální volbu), lze to provést pomocí zástupného znaku \n:

polickoTerminuKurzu.sendKeys("\n");
