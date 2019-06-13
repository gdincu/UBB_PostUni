1)
# - Intr-un fisier care contine mai multe nume pe diferite linii (numele se pot repeta) numele vostru
cat File1.txt | grep --color London

# recursivin toatefisierelecare contincaracterula incepanddin HOME 
cat /$HOME *.txt | grep --color "a"

2)
 # Afișați liniile care încep cu trei cifre urmate de un spați
cat grep_ex.txt | grep --color "^[0-9]\{3\}"

# Afișați liniile care conțin o vocală (a,e,i,o,u) urmată de orice caracter, și apoi de ovocală 
cat grep_ex.txt | grep --color "[aeiou].[aeiou]"

# Afișați toate liniile care nu încep cu S 
cat grep_ex.txt | grep --color -v "^S"

# Afișați toate liniile care conțin ca (case insensitive
cat grep_ex.txt | grep --color -i "ca"

# Afișați liniile care conțin o adresă de email, precendată de numărul liniei
cat grep_ex.txt | grep --color -i ".*@.*\..*" -n

# Afișați toate liniile care nu conțin cuvântul Sep.
cat grep_ex.txt | grep --color -v "\<Sep\>\."

 # Afișați liniile care conțin cuvântul de 
 cat grep_ex.txt | grep --color "\<de\>"
 
 # Afisatinumarulde liniiin care cuvantul“High” se gasestein fisierulgrep-ex.txt
 cat grep_ex.txt | grep --color -n "\<High\>" | wc -l
 grep -c "\<High\>" grep_ex.txt
 
 3) 
 # Adaugatio liniede forma: Angajat, IdAinaintede prima liniein fisierul fis.txt. 
 head -n 1 fis.txt | sed -i "s/./Angajat, IdA\n&/" # doar o afiseaza
 sed -i '1 i Angajat, IdA' fis.txt # face si amend fisierului cu textul introdus
 
 4)
 # Adaugatio liniede forma ------------dupaprima liniein fisierulfis.txt. 
 sed -i '2 i ------------' fis.txt # face si amend fisierului cu textul introdus
 
 5)
 #Adaugatio liniede forma ------------la sfarsitulfisieruluifis.txt. 
 sed -a '$ i ------------' fis.txt # face si amend fisierului cu textul introdus
 
 6)
 # Adaugatidupaliniacare continesirulde caractere“Angajat2” o noua inregistrarecare vacontine“Angajat5, 1005” 
 cat fis.txt | sed -i "a/"Angajat 2"/Angajat5, 1005/" # doar o afiseaza

 








