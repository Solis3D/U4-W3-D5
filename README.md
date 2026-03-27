# U4-W3-D5
Ho scelto di fare elemento_catalogo con Single Table poiché gli attributi in comune tra Libro e Rivista sono molti
e ci sono relativamente pochi null. Quindi gli attributi specifici di Libro sono soltanto "autore" e "genere",
per Rivista invece c'è soltanto "periodicita".

Tra utenti e prestito c'è una relazione 1:N, in quanto un utente può avere più prestiti.
Un elemento del catalogo può essere in più prestiti, quindi tra elemento_catalogo e prestito c'è sempre 1:N.
Ogni prestito quindi è associato a un solo utente e a un solo elemento del catalogo.

Nella mia interpretazione della traccia, in un prestito ci doveva essere un solo elemento del catalogo,
anche se in una biblioteca reale si potrebbero prendere più libri in un solo prestito.

Nella cartella src > main sono presenti gli screenshot di drawsql e il diagramma ERD preso da pgAdmin.