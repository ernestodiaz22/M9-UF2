<p></b>1.Per què s'atura l'execució al cap d'un temps?</br></b>
    Cuando se han hecho todas las reservas y los asistentes siguen intentándolo, acaba sucediendo que, por probabilidad, todos los asistentes restantes intenten hacer una reserva, quedando en espera y sin posibilidad de que otro hilo llame al método notifyAll(). </br></br></p>
<p>2.Què passaria si en lloc d'una probabilitat de 50%-50% fora de 70% (ferReserva)-30% (cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels dos casos.</b></br></p>
<p>-Porcetanje 50%-50%</br></p>
<img src="img/image4.png" alt=""></br>
<img src="img/image.png" alt="">
<img src="img/image2.png" alt="">
<img src="img/image3.png" alt="">
<img src="img/image3.png" alt="">
<p>-Porcetanje 70%-30%</p></br>
<img src="img/image5.png" alt=""></br>
<img src="img/image7.png" alt="">
<img src="img/image6.png" alt="">
<img src="img/image8.png" alt=""></br>

<p>Al aumentar el porcentaje de reservas, el código presenta mayores posibilidades de quedarse sin reservas, dejando a todos los asistentes en espera</br></br></p>

<p></b>3.Per què creus que fa falta la llista i no valdria només amb una variable sencera de reserves?</b></br></p>
<p>Sin la lista, sería imposible llevar un control de las cancelaciones, ya que desconoceríamos quiénes son los dueños de las reservas.</p>