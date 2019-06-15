def determina_putere(n):
    """
    Determina ce putere a lui 2 este prima cea mai mare
    decat n
    :param (int) n: numarul de IP-uri necesare
              citit de la tastatura
    :return (int) putere: puterea lui 2 potrivita
    """
    putere = 1

    while 2**putere < n+2:
        putere += 1

    return putere


def determina_netmask_bin(putere):
    """
    Determina netmask-ul potrivit
    :param (int) putere: numarul de 0-uri din netmask
    :return (str) netmask: string reprezentand netmask-ul
    """
    ones = 32 - putere
    str_bin_netmask = ""

    for i in range(0, 32):
        if i < ones:
            str_bin_netmask += "1"
        else:
            str_bin_netmask += "0"
        if len(str_bin_netmask.replace(".", "")) % 8 == 0:
            str_bin_netmask += "."

    return str_bin_netmask[:len(str_bin_netmask)-1]


def determina_netmask_dec(netmask_binar):
    """
    Ia netmask-ul in format binar si il transforma in decimal
    :param (str) netmask_binar:
    :return (str) netmask_dec: formatat in decimal
    """
    nums = netmask_binar.split(".")
    netmask_dec = ""

    for num in nums:
        netmask_dec += str(int(num, 2))
        netmask_dec += "."

    return netmask_dec[:len(netmask_dec)-1]


def adresa_inceput(netmask, ip):
    """
    Ia un netmask si un IP si determina adresa de inceput
    a retelei
    :param (str) netmask:
    :param (str) ip:
    :return adresa_inceput (str):
    """
    netmask_nums = netmask.split(".")
    ip_nums = ip.split(".")
    adresa_inceput = ""

    for i in range(0, 4):
        adresa_num = int(netmask_nums[i]) & int(ip_nums[i])
        adresa_inceput += str(adresa_num)
        adresa_inceput += "."

    return adresa_inceput[:len(adresa_inceput)-1]


def adresa_sfarsit(netmask, ip):
    """
    Ia un netmask si un IP si determina adresa de sfarsit
    a retelei
    :param (str) netmask:
    :param (str) ip:
    :return adresa_inceput (str):
    """
    netmask_nums = netmask.split(".")
    ip_nums = ip.split(".")
    adresa_sfarsit = ""

    for i in range(0, 4):
        adresa_num = int(ip_nums[i]) | int(255 - int(netmask_nums[i]))
        adresa_sfarsit += str(adresa_num)
        adresa_sfarsit += "."

    return adresa_sfarsit[:len(adresa_sfarsit)-1]

if __name__ == "__main__":

    n = int(input("Introdu numarul de IP-uri necesare: "))
    print("Clasa de IP-uri va avea {} adrese".format(2**determina_putere(n)))
    netmask_binar = determina_netmask_bin(determina_putere(n))
    netmask_dec = determina_netmask_dec(netmask_binar)
    print("Netmask:", netmask_dec)

    ip = input("Introdu IP random din retea pentru a determina adresele de inceput si sfarsit: ")
    print("Adresa inceput:", adresa_inceput(netmask_dec, ip))
    print("Adresa sfarsit:", adresa_sfarsit(netmask_dec, ip))