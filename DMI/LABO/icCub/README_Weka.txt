Ajout du pilote mysql au classpath
- Une fois Weka installé dans Applications
- Clic-droite sur weka-3-6-11.app
- Afficher le contenu du paquet
- Aller dans Contents
- Ouvrir Info.plist
	- Dérouler la partie Java:
	- Ajouter à ClassPath, l'emplacement (absolu) de mysql-connector-java-5.1.34-bin.jar
- Fermer/Ouvrir weka


Erreur lors du démarrage Weka sous Mountain Lion: 

-------------------------------
Hi folks,

After upgrading my laptop to Mountain Lion today I discovered that 
trying to open the Weka Mac application resulted in a "weka-3-6-7" is 
damaged and can't be opened." error.

After hunting around a bit it turns out that there is a brand new 
security feature in Mountain Lion that, by default, limits "acceptable" 
applications to only those downloaded from the Mac App store. 
Thankfully, you can alter this in the system preferences. Go to 
"Security & Privacy" and change the "Allow applications downloaded 
from:" to "Anywhere". Weka will launch successfully after this change.

Cheers,
Mark.

https://list.scms.waikato.ac.nz/mailman/htdig/wekalist/2012-July/055939.html [LIEN MORT...]