# INF138 Project Template

Ένα απλό πρότυπο οργάνωσης του κώδικα και της τεχνικής τεκμηρίωσης για τις εξαμηνιαίες εργασίες του μαθήματος Τεχνολογία Λογισμικού ([INF138](https://eclass.aueb.gr/courses/INF138/)) του Τμήματος Πληροφορικής Οικονομικού Πανεπιστημίου Αθηνών.

Η τρέχουσα έκδοση περιλαμβάνει την [προδιαγραφή των απαιτήσεων λογισμικού](docs/markdown/software-requirements.md) με προσαρμογή του `IEEE Std 830-1998` για την ενσωμάτωση απαιτήσεων σε μορφή περιπτώσεων χρήσης. Για περισσότερες λεπτομέρειες μπορείτε να ανατρέξετε στο βιβλίο [Μ Γιακουμάκης, Ν. Διαμαντίδης, Τεχνολογία Λογισμικού, Σταμούλης, 2009](https://www.softeng.gr).

# Οδηγίες χρήσης

Στην παρούσα αρχική σελίδα `README.md` προσθέστε σε μορφή Markdown την περιγραφή του Project όπως σας ζητείται στο παραδοτέο R1. Στη σελίδα αυτή θα προστεθούν σύνδεσμοι προς τα έγγραφα Markdown που περιλαμβάνουν την προδιαγραφή και ανάλυση των απαιτήσεων [software-requirements.md](docs/markdown/software-requirements.md) και τη σχεδίαση του συστήματος [design.md](docs/markdown/design.md).

Η τεκμηρίωση/διαγράμματα που ζητούνται στα επόμενα παραδοτέα θα τοποθετηθούν στους εξής φακέλους:
* `docs/markdown`: αρχεία Markdown με την τεκμηρίωση του συστήματος που απαιτείται για τα παραδοτέα R2-R4. H τεκμηρίωση θα συμπεριληφθεί στα ακόλουθα αρχεία:
     *  `software-requirements.md`: προδιαγραφή και ανάλυση των απαιτήσεων. Προκειμένου να διευκολυνθεί η συνεργασία σας, οι περιγραφές των περιπτώσεων χρήσης μπορούν να εισαχθούν σε διαφορετικά αρχεία `*.md`. Προϋπόθεση είναι να υπάρχουν κατάλληλοι σύνδεσμοι από το `software-requirements.md` προς αυτά έτσι ώστε να διευκολύνεται η πλοήγηση στην τεκμηρίωση μέσω του Gitlab. Τα διαγράμματα που θα δημιουργηθούν στα πλαίσια του R2 θα ενσωματωθούν στα παραπάνω έγγραφα (δεν θα λάβουμε υπόψιν διαγράμματα με μορφή εικόνας/uxf που δεν θα φαίνονται ως μέρος της τεκμηρίωσης).
     *  `design.md`: περιγραφή της σχεδίασης του συστήματος όπως ζητείται στα παραδοτέα R3 και R4. To έγγραφο θα ενσωματώνει όλα τα διαγράμματα που θα δημιουργηθούν στα παραδοτέα R3, R4. Οι εικόνες των διαγραμμάτων θα είναι διαθέσιμες στο φάκελο `docs/markdown/uml`, όπως παράγονται από το εργαλείο Gradle.
* `docs/uml`: αρχεία Umlet (`*.uxf`) με τα διαγράμματα που έχουν υλοποιηθεί στα πλαίσια των παραδοτέων R2-R4. Μπορούν να οργανωθούν σε υποφακέλους (πχ. `requirements`, `design`).

Η αυτοματοποιημένη μετατροπή των διαγραμμάτων Umlet σε PNG εικόνες, έτοιμες προς ενσωμάτωση στην Markdown τεκμηρίωσή σας μπορεί να γίνει με χρήση του εργαλείου Gradle. Προϋπόθεση για τη σωστή λειτουργία της διαδικασίας είναι η [λήψη](https://maven.apache.org/download.cgi), [εγκατάσταση](https://maven.apache.org/install.html) και προσθήκη στο PATH του συστήματος του εργαλείου Maven.

Μετά την εγκατάσταση του Maven, μπορείτε να παράξετε όλα τα διαγράμματα που βρίσκονται στον κατάλογο `docs\uml` (και υποκαταλόγους) με τη βοήθεια του Gradle (δε χρειάζεται εγκατάσταση):

Από γραμμή εντολών Windows:
```bash
gradlew.bat umlet
```

Από γραμμή εντολών Linux:
```bash
./gradlew umlet
```

Η εκτέλεση της εντολής θα εγκαταστήσει το Gradle και θα παράξει τα διαγράμματα στον κατάλογο `docs\markdown\uml` διατηρώντας την οργάνωση σε καταλόγους των Umlet αρχείων. Στη συνέχεια, μπορείτε να ενσωματώσετε στην τεκμηρίωσή σας τις εικόνες του παραπάνω καταλόγου.

# Εφαρμογή συνταγών

Η εφαρμογή αυτή θα προτείνει στους εγγεγραμμένους χρήστες μαγειρικές συνταγές που έχουν υποβληθεί από άλλους χρήστες λαμβάνοντας υπόψη ορισμένους παράγοντες. Ο κυριότερος παράγοντας θα είναι τα υλικά που έχει διαθέσιμα ο χρήστης τα οποία και θα δηλώνει. Επιπλέον ο χρήστης θα δηλώνει τον χρόνο που έχει διαθέσιμο για την προετοιμασία του γεύματος ώστε η εφαρμογή να δίνει βάρος σε συνταγές με μικρότερη διάρκεια προετοιμασίας ή αν δεν είναι κάποια συνταγή με μικρότερο χρόνο διαθέσιμη τότε η εφαρμογή θα προτείνει κάποια με τον λιγότερο δυνατό προσθετό χρόνο. Επίσης ο χρήστης θα έχει την δυνατότητα να βαθμολογεί τις συνταγές που του προτείνονται σε μια κλίμακα και με βάση αυτή την βαθμολογία η εφαρμογή θα προτείνει φαγητά παρόμοια με αυτά που αρέσουν στον χρήστη. Ακόμα η εφαρμογή θα προσπαθεί να προτείνει στον χρήστη μεγάλη ποικιλία γευμάτων με βάση το αν έχει προτείνει ξανά πρόσφατα μια συνταγή. Η εφαρμογή θα έχει και φίλτρο για τα είδη γευμάτων που θα εμφανίζονται στον χρήστη (π.χ. ορεκτικό, κυρίως πιάτο κ.λπ..). Η εφαρμογή θα εμφανίζει τις συνταγές που πληρούν τις προϋποθέσεις με σειρά προτεραιότητας από πόσο καλά πληρούνται οι προτιμήσεις του χρήστη και θα εμφανίζει την διαδικασία εκτέλεσης. Οταν υποβάλλεται μια συνταγή απαιτείται η καταχώρηση των στοιχείων που είναι απαραίτητα για τις λειτουργίες της εφαρμογής. Τέλος, το σύστημα θα υπολογίζει τις θερμίδες κάθε συνταγής βάσει τις ποσότητας και του είδους των υλικών της και με γνώμονα την θερμιδική αξία των υλικών, η οποία καχωρείται από τον διαχειριστή του συστήματος.

# Απαιτήσεις

1. Ο χρήστης δηλώνει τα υλικά που έχει διαθέσιμα.
2. Ο χρήστης δηλώνει τον διαθέσιμο χρόνο.
3. Η εφαρμογή θα έχει φίλτρο για τα είδη γευμάτων που θα εμφανίζονται στον χρήστη.
4. Η εφαρμογή δεν θα εμφανίζει συνταγές οι οποίες δεν πληρούν τις προϋποθέσεις υλικών.
5. Η εφαρμογή εμφανίζει στον χρήστη τις συνταγές που παίρνουν λιγότερο ή ίσο χρόνο με τον διαθέσιμο.
6. Αν δεν υπάρχουν, θα εμφανίζει στον χρήστη άλλες συνταγές, καταταγμένες σε αύξουσα σειρά με βάση τον χρόνο που παίρνουν. Σε περίπτωση ισοβαθμίας, θα λαμβάνονται υπόψη οι προτιμήσεις του χρήστη.
7. Οι συνταγές θα εμφανίζονται με σειρά προτεραιότητας με βάση της προτιμήσεις του χρήστη.
8. Ο χρήστης θα έχει την δυνατότητα να βαθμολογεί τις συνταγές που του προτείνονται σε μια κλίμακα.
9. Με βάση αυτή την βαθμολογία, η εφαρμογή θα προτείνει φαγητά παρόμοια με αυτά που αρέσουν στον χρήστη.
10. Η εφαρμογή θα προσπαθεί να προτείνει στον χρήστη μεγάλη ποικιλία γευμάτων με βάση το αν έχει προτείνει ξανά πρόσφατα μια συνταγή.
11. Η υπηρεσία θα διατίθεται σε εγγεγραμμένους χρήστες.
12. Οι χρήστες θα έχουν τη δυνατότητα καταχώρησης συνταγών.
13. Για την καταχώρηση συνταγών, ο χρήστης θα δίνει λεπτομέρειες για την κάθε συνταγή, όπως χρόνος ολοκλήρωση, υλικά, είδος γεύματος, αριθμός μερίδων, βήματα.
14. Το σύστημα προτείνει συνταγές επιλέγοντας από τις συνταγές που έχουν καταχωρηθεί από τους υπόλοιπους χρήστες.
15. Το σύστημα θα υπολογίζει τις θερμίδες κάθε συνταγής, βάσει τις ποσότητας και του είδους των υλικών της.
16. Τα υλικά και η θερμιδική τους αξία θα καταχωρούνται από το διαχειριστή του συστήματος.


[Διάγραμμα περιπτώσεων χρήσης](uml/requirements/use_case_uml_diagram.png)

