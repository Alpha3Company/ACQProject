ACQProject
==========

Alpha3
Oriol Querol, Gerard Font i Josep Mir
Auditoria i Certifiació de la Qualitat
Alpha3


El problema
El dilema dels viatgers
Una línia aèria perd dues maletes pertanyents a dos viatgers diferents. Resulta que totes dues maletes són idèntiques i totes dues contenen els mateixos ítems. Un encarregat de la línia aèria assignat a la gestió de les reclamacions de tots dos viatgers els explica que la línia es fa responsable d’una quantia màxima de 100€ per maleta (ell és incapaç de determinar directament l’import dels ítems), i amb el fi de trobar un valor de taxació honesta dels ítems l’encarregat separa els dos viatgers, amb el que no poden parlar entre ells, i els demana que escriguin el valor de les seves maletes amb un valor mínim de 2€ i un màxim de 100€. A més els diu el següent:
 Si els dos escriuen el mateix número, tractarà aquesta quantia com el valor real de les maletes i reemborsarà els dos viatgers amb aquesta quantia.
 Si un dels dos escriu un valor més petit que l’altre, es prendrà el valor menor com el valor real de les maletes i tots dos viatgers rebran aquesta quantia amb una bonificació i penalització segons el següent:
o Es pagaran 2€ extra al viatger que escrigui el valor més baix.
o Es pagaran 2€ menys al viatger que escrigui el valor més alt.
El repte és: quina estratègia haurien de seguir els viatgers per decidir el valor que haurien d’escriure?
El dilema dels viatgers iterats
La situació esmentada anteriorment és una recreació del dilema dels viatgers a una volta i ens servirà com a base pel cas més interessant de fer vàries rondes del joc dels viatgers (un nombre prefixat d'elles). Primer introduirem la nomenclatura que s'utilitza habitualment en teoria de jocs.
Suposem que hi ha dos jugadors A i B que poden escollir, individualment i de forma simultània, el valor de les maletes. Els resultats de la ronda, expressats en la matriu d'utilitat 1 (payoff matrix), són els següents:
L'objectiu a llarg termini és guanyar el màxim de punts al final d'un nombre determinat de voltes. A cada volta, tots dos jugadors es decideixen el valor de la maleta de forma simultània i sense conèixer la decisió de l'altre (com a l'apartat anterior). Això sí, a l’analitzar cada ronda, s'atorguen els punts segons la matriu i s'informa a cada jugador de l'opció triada per l'altre jugador (de manera que, a la ronda n el jugador coneix, i pot utilitzar si vol, els resultats de les n-1 rondes anteriors).
1 La utilitat mesura el benefici que cada jugador obté al finalitzar cada ronda. Pot mesurar punts, diners
o el nivell de satisfacció personal que li proporciona el resultat.
Anomenarem algorisme de decisió l'algorisme seguit per cada jugador per tal de decidir quin valor atorga a la maleta (pot fer ús de la història de la partida jugada fins al moment).


Exemples d'estratègies:
 Ambiciosa: Declarar sempre 100€.
 X-osa: Declarar sempre X€, on X és entre 2 i 100.
 Espavilat: Declarar 99€ de cost amb l’objectiu d’obtenir-ne 101€ si el contrari diu 100€.
 Aleatori: Generar un valor entre 2€ i 100€ aleatori.
 Intel·ligent: tenir en compte les rondes anteriors per tan de prendre la decisió.
No hi ha una estratègia òptima en el sentit de què és la millor davant qualsevol altra ja que, els resultats d'una estratègia depenen de quina sigui l'estratègia seguida per l'altre jugador. Per exemple, Espavilat si s'enfronta a Ambiciosa obté el màxim de diners. Vol dir això que és millor? No, ja que els diners que fa una estratègia depenen de l'estratègia que utilitza el contrincant. Quan dos Espavilat s'enfronten cadascun obté 99€ però quan dos Ambiciosa juguen entre si cadascun obté 100€.
La pràctica consistirà en aplicar les tècniques d’anàlisi, disseny i programació orientada a objectes a una versió d’aquest torneig.
Es vol realitzar una aplicació per simular tornejos del dilema dels viatgers iterat. En concret, l'usuari podrà escollir l'estratègia emprada per cada jugador i el nombre de rondes que tindrà la partida. De cara a fer això, el sistema tindrà implementades diverses estratègies predefinides (algunes d'elles cegues, algunes probabilistes i d'altres intel·ligents).
També permetrem la definició d'estratègies mixtes que es formin per combinació de dues o més estratègies definides en el sistema (així podrem ampliar el repertori d'estratègies). Per exemple: una forma de combinar seria escollir tres estratègies base i retornar el resultat de la majoria. Per a fer això, el sistema tindrà definit un mecanisme de combinació d'estratègies que permeti definir noves estratègies per a ser utilitzades a les partides.


Requeriments
1- S’ha de poder crear una partida
2- S’ha de poder definir noves estratègies
3- Les estratègies poden ser simples o compostes d’altres estratègies, simples o compostes.
4- S’han de poder associar estratègies a partides.
5- S’han de poder definir nous observadors.
6- S’han de poder associar observadors a la partida.
7- S’ha de contemplar la possibilitat d’afegir altres tipus de jugadors i de partides en un futur.
8- S’ha de registrar un històric de les partides.
