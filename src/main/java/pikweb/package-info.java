/**
 * Ta aplikacja dostarcza WebAPI współpracujące z interfejsem naszej aplikacji na PIK.
 *
 * Aplikacja wykonana jest jako usługa sieciowa, w standardzie REST - w odpowiedzi na zapytania zwraca pobrane z bazy danych informacje w formacie JSON.
 *
 * Dostępne są nastepująca zapytania:
 *
 * <ul>
 *
 *     <li><b>/add/user?login='jakis_login' &amp; passhash='jakis_hash'</b>   - dodaje do bazy nowego użytkownika o loginie 'jakis_login' i haśle 'jakis_hash' </li>
 *
 *     <li><b>/login/user?login='jakis_login' &amp; passhash='jakis_hash'</b>    - sprawdza czy istnieje w bazie użytkownik o loginie 'jakis_login' i haśle 'jakis_hash'. Jeśli tak, ustawia identyfikator sesji użytkownika, zapisując nazwę użytkownika w parametrze "username" sesji. Zwraca status 400 i nie ustawia sesji, jeśli hasło lub nazwa użytkownika są niepoprawne. </li>
 *
 *     <li><b>/logout/user?login='jakis_login'</b>    - Kończy sesję użytkownika 'jakis_login', jeśli ten użytkownik był zalogowany. </li>
 *
 *     <li><b>/delete/user?login='jakis_login' &amp; passhash='jakis_hash'</b>   - usuwa z bazy użytkownika 'jakis_login' jeśli tylko podane hasło jest poprawne. Wraz z użytkownikiem usuwane są wszystkie skojarzone z nim punkty. Zwraca status 400 jeśli podane hasło lub nazwa użytkownika były niepoprawne. </li>
 *
 *     <li><b>/get/user/points?session='id_sesji'</b>   - zwraca listę w formacie JSON wszystkich punktów zalogowanego użytkownika. </li>
 *
 *     <li><b>/add/user/points?session='id_sesji' &amp; latitude='latit' &amp; logitute='logit' &amp; name='name'</b>   - dodaje do bazy nowy punkt dla zalogowanego użytkownika. </li>
 *
 *     <li><b>/delete/user/points?session='id_sesji' &amp; name='name'</b>   - usuwa z bazy punkt o nazwie 'name', będący własnością zalogowanego użytkownika. </li>
 *
 *     <li><b>get/points?session='id_sesji'</b>   - zwraca listę w formacie JSON wszystkich istniejących w bazie punktów, o ile tylko użytkownik jest zalogowany. </li>
 *
 * </ul>
 *
 * <p>
 *     Dalsza dokumentacja dostępna w opisach poszczególnych klas. Wszelkie pytania kierować w stronę autora i dewelopera projektu.
 * </p>
 *
 * <p>
 *     UWAGA: metody
 *      <ul>
 *          <li>{@link pikweb.RESTController#userPoints()}</li>
 *          <li>{@link pikweb.RESTController#addUserPoints()}</li>
 *          <li>{@link pikweb.RESTController#deleteUserPoints()}}</li>
 *          <li>{@link pikweb.RESTController#getPoints()}</li>
 *     </ul>
 *
 *      pozostają wciąż do zaimplementowania.
 * </p>
 *
 *
 * <p>
 *     Copyright 2017 Artur M. Brodzki &amp; Julita Ołtusek.
 * </p>
 *
 *
 */
package pikweb;