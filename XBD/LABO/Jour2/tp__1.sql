-- exercice 1
SELECT XMLELEMENT("radio",
  XMLATTRIBUTES(r.NOM as "Nom", f.FREQUENCE as "Fr�quences")) AS TEST
FROM RADIOS r 
inner join FREQUENCES f on (r.IDRADIO = f.IDRADIO)
inner join VILLES v on (f.IDVILLE = v.IDVILLE)
WHERE v.NOM = 'Fribourg';

-- exercice 2
SELECT XMLELEMENT("StationRadio",
  XMLATTRIBUTES(f.FREQUENCE as "frequence"),
  XMLELEMENT("Nom",r.NOM),
  XMLELEMENT("Genre",r.GENRE),
  XMLELEMENT("Villes")) AS TEST
FROM RADIOS r 
inner join FREQUENCES f on (r.IDRADIO = f.IDRADIO)
inner join VILLES v on (f.IDVILLE = v.IDVILLE)
WHERE v.NOM = 'Gen�ve';

--- exercice 3
SELECT XMLELEMENT("Radios",
  XMLELEMENT("Nom", r.NOM),
  XMLELEMENT("Genre", r.GENRE),
  XMLELEMENT("Villes",
  (SELECT XMLAGG(
    XMLELEMENT("Ville",
      XMLELEMENT("NPA",v.NPA),
      XMLELEMENT("Nom",v.NOM),
      XMLELEMENT("Fr�quences",
        (SELECT XMLAGG(
          XMLELEMENT("Fr�quence",f2.FREQUENCE))
        FROM FREQUENCES f2 WHERE f.IDVILLE = f2.IDVILLE)
        ))
  ) 
    FROM VILLES v 
    INNER JOIN FREQUENCES f on (f.IDVILLE = v.IDVILLE)
    WHERE v.IDVILLE = f.IDVILLE AND f.IDRADIO = r.IDRADIO)
  )
) AS TEST
FROM RADIOS r;

--- exercice 4
SELECT XMLELEMENT("VilleRadio",
  (SELECT XMLAGG(
    XMLELEMENT("Ville",
      XMLATTRIBUTES(v.NOM as "Nom"),
      (SELECT XMLAGG(
        XMLELEMENT("Radio",
          XMLATTRIBUTES(r.NOM as "nom",f.FREQUENCE as "frequence"))) 
      FROM RADIOS r 
      INNER JOIN FREQUENCES f on (f.IDRADIO = r.IDRADIO)
      WHERE v.IDVILLE = f.IDVILLE))) 
  FROM VILLES v
  )
)
FROM DUAL;

SELECT XMLElement("VilleRadio",
  XMLAgg(XMLElement("Ville",
  XMLAttributes(v.Nom as "Nom"),
  (SELECT
    XMLAgg(
      XMLElement("Radio",
      XMLAttributes(r.nom as "nom", f.Frequence as "frequence")
  )
  order by r.nom
  )
FROM Radios r, Frequences f
WHERE r.IdRadio=f.IdRadio AND v.IdVille=f.IdVille))
order by v.nom
)
)
FROM Villes v; 

XMLROOT( XMLType('<poid>143598</poid>'), VERSION '1.0', STANDALONE YES)