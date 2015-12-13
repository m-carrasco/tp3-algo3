import random

def generarArbolMinimo(name):
    f = open(name, 'w')
    c = 2
    n=20
    f.write(str(n) + " " + str(n-1) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = random.sample([1,2],2)
        f.write(str(2) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    f.write("0 1" + "\n")
    f.write("1 14" + "\n")
    f.write("1 2" + "\n")
    f.write("14 16" + "\n")
    f.write("14 15" + "\n")
    f.write("15 17" + "\n")
    f.write("15 18" + "\n")
    f.write("18 19" + "\n")
    f.write("2 7" + "\n")
    f.write("2 6" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("3 5" + "\n")
    f.write("7 8" + "\n")
    f.write("7 9" + "\n")
    f.write("7 10" + "\n")
    f.write("10 11" + "\n")
    f.write("10 12" + "\n")
    f.write("8 13" + "\n")
    f.close()

def generarArbolMaximo(name):
    f = open(name, 'w')
    c = 4
    n=20
    f.write(str(n) + " " + str(n-1) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = random.sample([1,2,3,4],4)
        f.write(str(4) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    

    f.write("0 1" + "\n")
    f.write("1 14" + "\n")
    f.write("1 2" + "\n")
    f.write("14 16" + "\n")
    f.write("14 15" + "\n")
    f.write("15 17" + "\n")
    f.write("15 18" + "\n")
    f.write("18 19" + "\n")
    f.write("2 7" + "\n")
    f.write("2 6" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("3 5" + "\n")
    f.write("7 8" + "\n")
    f.write("7 9" + "\n")
    f.write("7 10" + "\n")
    f.write("10 11" + "\n")
    f.write("10 12" + "\n")
    f.write("8 13" + "\n")
    f.close()

def generarArbolAleatorio(name):
    f = open(name, 'w')
    c = 2
    n=20
    f.write(str(n) + " " + str(n-1) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = random.sample([1,2,3,4], random.randint(2,4))
        
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    f.write("0 1" + "\n")
    f.write("1 14" + "\n")
    f.write("1 2" + "\n")
    f.write("14 16" + "\n")
    f.write("14 15" + "\n")
    f.write("15 17" + "\n")
    f.write("15 18" + "\n")
    f.write("18 19" + "\n")
    f.write("2 7" + "\n")
    f.write("2 6" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("3 5" + "\n")
    f.write("7 8" + "\n")
    f.write("7 9" + "\n")
    f.write("7 10" + "\n")
    f.write("10 11" + "\n")
    f.write("10 12" + "\n")
    f.write("8 13" + "\n")
    f.close()

def generarCompletoMinimo(name):
    f = open(name, 'w')
    n=20
    m = (n*(n-1))/2
    c = 20
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    for i in range(0, n):
        listaColores = random.sample([x for x in range(1,21)],20)
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        for arista in ady:  
            f.write(arista + "\n")

    f.close()

def generarCompletoMaximo(name):
    f = open(name, 'w')
    n=20
    m = (n*(n-1))/2
    c = 40
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    for i in range(0, n):
        listaColores = random.sample([x for x in range(1,41)],40)
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        for arista in ady:  
            f.write(arista + "\n")

    f.close()

def generarCompletoAleatorio(name):
    f = open(name, 'w')
    n=20
    m = (n*(n-1))/2
    c = 20
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    repertorio = [x for x in range(1,41)]
    for i in range(0, n):
        listaColores = random.sample(repertorio, random.randint(20,40))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        for arista in ady:  
            f.write(arista + "\n")

    f.close()

def generarRuedaMinima(name):
    f = open(name, 'w')
    c = 3
    n=20
    m=38
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = random.sample([1,2,3],3)
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    
    f.write("1 2" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("4 5" + "\n")
    f.write("5 6" + "\n")
    f.write("6 7" + "\n")
    f.write("7 8" + "\n")
    f.write("8 9" + "\n")
    f.write("9 10" + "\n")
    f.write("10 11" + "\n")
    f.write("11 12" + "\n")
    f.write("12 13" + "\n")
    f.write("13 14" + "\n")
    f.write("14 15" + "\n")
    f.write("15 16" + "\n")
    f.write("16 17" + "\n")
    f.write("17 18" + "\n")
    f.write("18 19" + "\n")
    f.write("19 1" + "\n")
    f.write("0 1" + "\n")
    f.write("0 2" + "\n") 
    f.write("0 3" + "\n")  
    f.write("0 4" + "\n")  
    f.write("0 5" + "\n")  
    f.write("0 6" + "\n")  
    f.write("0 7" + "\n")  
    f.write("0 8" + "\n")  
    f.write("0 9" + "\n")  
    f.write("0 10" + "\n")  
    f.write("0 11" + "\n")  
    f.write("0 12"+ "\n")  
    f.write("0 13" + "\n")  
    f.write("0 14" + "\n")  
    f.write("0 15" + "\n")     
    f.write("0 16" + "\n")  
    f.write("0 17" + "\n")  
    f.write("0 18" + "\n")  
    f.write("0 19" + "\n")       
    f.close()

def generarRuedaMaxima(name):
    f = open(name, 'w')
    c = 6
    n=20
    m=38
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    for i in range(0, n):
        listaColores = random.sample([1,2,3,4,5,6],6)
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

       
    f.write("1 2" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("4 5" + "\n")
    f.write("5 6" + "\n")
    f.write("6 7" + "\n")
    f.write("7 8" + "\n")
    f.write("8 9" + "\n")
    f.write("9 10" + "\n")
    f.write("10 11" + "\n")
    f.write("11 12" + "\n")
    f.write("12 13" + "\n")
    f.write("13 14" + "\n")
    f.write("14 15" + "\n")
    f.write("15 16" + "\n")
    f.write("16 17" + "\n")
    f.write("17 18" + "\n")
    f.write("18 19" + "\n")
    f.write("19 1" + "\n")
    f.write("0 1" + "\n")
    f.write("0 2" + "\n") 
    f.write("0 3" + "\n")  
    f.write("0 4" + "\n")  
    f.write("0 5" + "\n")  
    f.write("0 6" + "\n")  
    f.write("0 7" + "\n")  
    f.write("0 8" + "\n")  
    f.write("0 9" + "\n")  
    f.write("0 10" + "\n")  
    f.write("0 11" + "\n")  
    f.write("0 12"+ "\n")  
    f.write("0 13" + "\n")  
    f.write("0 14" + "\n")  
    f.write("0 15" + "\n")     
    f.write("0 16" + "\n")  
    f.write("0 17" + "\n")  
    f.write("0 18" + "\n")  
    f.write("0 19" + "\n")      
    f.close()

def generarRuedaAleatoriaN(name, n):
    f = open(name, 'w')
    c = 3
    m=2*(n-1)
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    repertorio = [x for x in range(1,7)]
    for i in range(0, n):
        listaColores = random.sample(repertorio, random.randint(3,6))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
 
	
    ady = ["0 " + str(x) for x in range(1, n)]
    for arista in ady:  
        f.write(arista + "\n")

    ady = [str(x) + " " + str(x+1) for x in range(1, n-1)]
    for arista in ady:  
        f.write(arista + "\n")

    f.write(str(n-1) + " 1" + "\n")

    f.close()

def generarCompletoAleatorioN(name, n):
    f = open(name, 'w')
    m = (n*(n-1))/2
    c = 2
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    j = 0


    repertorio = [x for x in range(1,n*2+1)]
    for i in range(0, n):
        listaColores = random.sample(repertorio, random.randint(n, n*2))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        #ady = [str(i) + " " + str(i + 1)]        
        for arista in ady:  
            f.write(arista + "\n")

    f.close()


def generarCompletoAleatorioNC(name, n, c):
    f = open(name, 'w')
    m = (n*(n-1))/2
    c = 2
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    j = 0


   
    for i in range(0, n):
    	repertorio = [x for x in range(0,c)]
    	repertorio.remove(i%c)
        listaColores = [i % c] + repertorio
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
    for i in range(0, n):
        ady = [str(i) + " " + str(x) for x in range(i+1, n)]
        #ady = [str(i) + " " + str(i + 1)]        
        for arista in ady:  
            f.write(arista + "\n")

    f.close()


def generarRuedaAleatoria(name):
    f = open(name, 'w')
    c = 3
    n=20
    m=38
    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")
    repertorio = [x for x in range(1,7)]
    for i in range(0, n):
        listaColores = random.sample(repertorio, random.randint(3,6))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")
    
       
    f.write("1 2" + "\n")
    f.write("2 3" + "\n")
    f.write("3 4" + "\n")
    f.write("4 5" + "\n")
    f.write("5 6" + "\n")
    f.write("6 7" + "\n")
    f.write("7 8" + "\n")
    f.write("8 9" + "\n")
    f.write("9 10" + "\n")
    f.write("10 11" + "\n")
    f.write("11 12" + "\n")
    f.write("12 13" + "\n")
    f.write("13 14" + "\n")
    f.write("14 15" + "\n")
    f.write("15 16" + "\n")
    f.write("16 17" + "\n")
    f.write("17 18" + "\n")
    f.write("18 19" + "\n")
    f.write("19 1" + "\n")
    f.write("0 1" + "\n")
    f.write("0 2" + "\n") 
    f.write("0 3" + "\n")  
    f.write("0 4" + "\n")  
    f.write("0 5" + "\n")  
    f.write("0 6" + "\n")  
    f.write("0 7" + "\n")  
    f.write("0 8" + "\n")  
    f.write("0 9" + "\n")  
    f.write("0 10" + "\n")  
    f.write("0 11" + "\n")  
    f.write("0 12"+ "\n")  
    f.write("0 13" + "\n")  
    f.write("0 14" + "\n")  
    f.write("0 15" + "\n")     
    f.write("0 16" + "\n")  
    f.write("0 17" + "\n")  
    f.write("0 18" + "\n")  
    f.write("0 19" + "\n")     
    f.close()

# todos los nodos tienen 2 colores
def generarArbolBinarioMinimo(nombre, nivel, nivelMax):
    f = open(nombre, 'w')

    c = 3
    n=(2**nivelMax)-1
    m=(2**(nivelMax-1) - 1)*2

    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    repertorio = [x for x in range(1,3)]

    for i in range(0, n):
        listaColores = repertorio#random.sample(repertorio, random.randint(2,2))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    recursionAristas(f, nivel, nivelMax, 0)
    f.close()

# todos tienen 4 colores
def generarArbolBinarioMaximo(nombre, nivel, nivelMax):
    f = open(nombre, 'w')

    c = 3
    n=(2**nivelMax)-1
    m=(2**(nivelMax-1) - 1)*2

    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    repertorio = [x for x in range(1,5)]

    for i in range(0, n):
        listaColores = repertorio#random.sample(repertorio, random.randint(4,4))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    recursionAristas(f, nivel, nivelMax, 0)
    f.close()


# todos tienen entre 2 a 4 colores
def generarArbolBinarioAleatorio(nombre, nivel, nivelMax):
    f = open(nombre, 'w')

    c = 3
    n=(2**nivelMax)-1
    m=(2**(nivelMax-1) - 1)*2

    f.write(str(n) + " " + str(m) + " " + str(c) + "\n")

    repertorio = [x for x in range(1,5)]

    for i in range(0, n):
        listaColores = random.sample(repertorio, random.randint(2,4))
        f.write(str(len(listaColores)) + " " + str(listaColores).replace('[', '').replace(']','').replace(', ', ' ') + "\n")

    recursionAristas(f, nivel, nivelMax, 0)
    f.close()

def recursionAristas(f, nivel, nivelMax, id):
    if (nivel == nivelMax):
        return id+1
    f.write(str(id) + " " + str(id+1) + "\n")
    nextId = recursionAristas(f, nivel+1, nivelMax, id+1 )
    f.write(str(id) + " " + str(nextId) + "\n")
    nextId = recursionAristas(f, nivel+1, nivelMax, nextId)
    return nextId


generarArbolBinarioMinimo("entradaEj4ABMin.in", 1, 5)
generarArbolBinarioMaximo("entradaEj4ABMax.in", 1, 5)
generarArbolBinarioAleatorio("entradaEj4ABAle.in", 1, 5)

generarArbolMinimo("entradaEj4AMin.in")
generarArbolMaximo("entradaEj4AMax.in")
generarArbolAleatorio("entradaEj4AAle.in")
generarCompletoMinimo("entradaEj4CMin.in")
generarCompletoMaximo("entradaEj4CMax.in")
generarCompletoAleatorio("entradaEj4CAle.in")
generarRuedaMinima("entradaEj4RMin.in")
generarRuedaMaxima("entradaEj4RMax.in")
generarRuedaAleatoria("entradaEj4RAle.in")


generarRuedaAleatoriaN("entradaEj4RAleN512.in", 512)
generarArbolBinarioAleatorio("entradaEj4ABAleN512.in", 1, 9)
generarCompletoAleatorioN("entradaEj4CAleN100.in", 100)

generarCompletoAleatorioN("entradaEj4CAleN50.in", 50)
generarCompletoAleatorioN("entradaEj4CAleN5A.in", 5)
generarCompletoAleatorioN("entradaEj4CAleN5B.in", 5)


generarCompletoAleatorioNC("entradaEj4CN100C10.in", 100, 10)
generarCompletoAleatorioNC("entradaEj4CN200C10.in", 200, 10)
generarCompletoAleatorioNC("entradaEj4CN300C10.in", 300, 10)
generarCompletoAleatorioNC("entradaEj4CN400C10.in", 400, 10)
generarCompletoAleatorioNC("entradaEj4CN500C10.in", 500, 10)

