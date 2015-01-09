(: //bd/titre/text() :)

(: //bd/@numero/string() :)

(:for $titre in //serie/bd/titre
order by $titre descending
return $titre :)

(: //serie/bd[titre = "Nadia se marie"]/resume :)

(:
<titreOrd>
{
  for $titre in //serie/bd/titre
  order by $titre
  return <bd>{$titre}</bd>
}
</titreOrd>
:)

(:
for $titreSerie in //serie[titreserie="Lanfeust de Troy"]/bd/titre
return $titreSerie
:)

(:
for $bd in //serie/bd[sortie > 2000]
return <bd><titre>{$bd/titre/text()}</titre><sortie>{$bd/sortie/text()}</sortie></bd>
:)

(:
count(//serie[titreserie = "Le retour a la terre"]/bd)
:)

(:
let $bds := /collection
for $bd in $bds/serie/bd 
where empty($bd/resume) 
return $bd/titre
:)

(:
//serie/bd[contains(resume,"monde")]/../titreserie
:)

(:
//serie/bd[illustrateur/@ref = auteur/@ref]/titre
:)

(:
//serie/bd[contains(resume,"Jack Palmer") and contains(resume,"Ange Leoni")]/titre
:)

(:
let $auteurRef := //serie/bd[titre="Thanos l'incongru"]/auteur/@ref
return //personnes/personne[@id = $auteurRef]
:)

(:
let $didierRef := //personnes/personne[prenom = "Didier"]/@id/string()
let $listeBD := //serie/bd/illustrateur[@ref eq $didierRef]/../titre
return $listeBD
:)

(:
for $personne in /personnes/personne
order by $personne/nom,$personne/prenom
return 
<personne>{
  $personne/nom,
  $personne/prenom,
  for $bd in //bd[auteur/@ref = $personne/@id or illustrateur/@ref = $personne/@id]
  return $bd/titre
}</personne>
:)


(:
let $perRef := /personnes/personne/@id/string()
let $auteurSerie := //serie/bd/auteur[@ref = $perRef]
let $auteurHorsSerie  := //collection/bd/auteur[@ref = $perRef]

for $auteurS in distinct-values($auteurSerie/@ref)
return 
  $auteurS
:)

(:
for $auteur in //personnes/personne
return
<auteur>{
  $auteur,
  for $book in /collection//bd[auteur/@ref = $auteur/@id]
  return $book
}</auteur>
:)


for $auteur in //personnes/personne
return <auteur>{
  $auteur/nom,
  $auteur/prenom,
  <livres>{
  for $book in /collection/bd[auteur/@ref = $auteur/@id]
    return <livre>{
      <distribteur>{
        
      }</distribteur>
      $book,
      
    }</livre>  
  }</livres>
}</auteur>


