# Mini-projet POO
Galactic Conquest

# Pré-requis :

-Kit de developpement openjdk :

> `sudo apt-get install openjdk-8-jdk-headless`

# Description :

Le but de ce projet est de réaliser un jeu proche du jeu GalCon (pour Galactic Conquest). Le jeu se déroule dans une galaxie en proie à la guerre planétaire et met en scène des vaisseaux en masse parcourant la carte à la recherche de planètes à conquérir jusqu'à l'anéantissement de vos adversaires. C'est un Risk en temps réel. Chaque planète fabrique un certain nombre d'unités par seconde. A vous de les envahir pour dominer l'univers!

<p align="center"><img width='500px' src="http://emmanoe.delar.emi.u-bordeaux.fr/poo/galaxyc.png" /></p>

La galaxie contient :
une planète d'origine par joueur;
un ensemble de planètes neutres;
des zones "libres" (i.e. l'espace).

Les acteurs du jeu sont des vaisseaux avec des caractéristiques fixées (vitesse, temps de production, puissance d'attaque) - produits par les planètes contrôlées par un joueur.

Chaque joueur possède initialement une planète. Toutes les planètes - exceptées les neutres - peuvent produire des vaisseaux. Le taux de production de chaque planète est fixé à la création de cette dernière. À tout moment du jeu, seules les planètes contrôlées par un joueur peuvent produire des vaisseaux pour ce joueur.

Le jeu consiste à déplacer les vaisseaux de planète en planète. Pour ce faire, le joueur sélectionne à la souris une planète d'origine et une planète de destination en faisant un cliquer-glisser. Une fois l'ordre émis, une partie (en nombre contrôlable via un pourcentage) des vaisseaux décolle de la planète origine pour aller sur la planète de destination. Pendant que les vaisseaux se déplacent à l'écran, les planètes continuent de produire de nouveaux vaisseaux.

Lorsqu'un vaisseau atteint une planète,
soit la planète appartient au joueur qui a déplacé le vaisseau et il s'agit juste un mouvement de troupes (sa réserve de vaisseaux est alors incrémentée de 1);
soit elle n'appartient pas au même joueur et c'est une attaque "kamikaze" (sa réserve de vaisseaux est alors décrémentée de la puissance d'attaque du vaisseau, fixé par défaut à 1);
si la planète est neutre ou contrôlée par un autre joueur et si sa réserve est nulle lors de l'attaque, la planète est conquise et appartient au joueur qui a lancé l'attaque. Elle se met à produire des vaisseaux du même type que celui qui en a permis la conquête.
Un joueur perd quand il ne contrôle plus de planète. Le jeu se termine lorsqu'il n'y a plus qu'un seul joueur. 

# Compiler le programme :

1 - Deplacer vous dans le dossier javadelar/simpleui

2 - Compiler le programme :

> `javac src_basic/Main.java`

3 - lancer l'executable :

> `java -cp . src_basic.Main`
