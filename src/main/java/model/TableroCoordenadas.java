/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abiga
 */
public class TableroCoordenadas {
    
    private int indice;
     private Coordenadas [] recorrido= new Coordenadas[]{
    
        
        //indicar coordenadas
        new Coordenadas (285,458),//1
        new Coordenadas (285,439),//2
        new Coordenadas (292,415),//3
        new Coordenadas (295,400),//4
        new Coordenadas (295,364),//5
        new Coordenadas (293,340),//6
        new Coordenadas (292,318),//7
        new Coordenadas (286,298),//8
        new Coordenadas (307,275),//9
        new Coordenadas (331,285),//10
        new Coordenadas (351,289),//11
        new Coordenadas (376,281),//12
        new Coordenadas (401,280),//13
        new Coordenadas (426,285),//14
        new Coordenadas (447,286),//15
        new Coordenadas (471,287),//16
        new Coordenadas (473,225),//17
        new Coordenadas (471,174),//18
        new Coordenadas (447,170),//19
        new Coordenadas (423,168),//20
        new Coordenadas (400,167),//21
        new Coordenadas (378,172),//22
        new Coordenadas (354,168),//23
        new Coordenadas (331,171),//24
        new Coordenadas (307,180),//25
        new Coordenadas (285,160),//26
        new Coordenadas (269,136),//28
        new Coordenadas (291,111),//29
        new Coordenadas (297,66),//30
        new Coordenadas (299,41),//31
        new Coordenadas (295,19),//32
        new Coordenadas (295,1),//33
        new Coordenadas (244,1),//34
        new Coordenadas (179,0),//35
        new Coordenadas (180,18),//36
        new Coordenadas (179,40),//37
        new Coordenadas (183,61),//38
        new Coordenadas (186,88),//39
        new Coordenadas (184,111),//40
        new Coordenadas (186,135),//41
        new Coordenadas (186,157),//42
        new Coordenadas (173,174),//43
        new Coordenadas (148,171),//44
        new Coordenadas (125,175),//45
        new Coordenadas (101,172),//46
        new Coordenadas (79,171),//47
        new Coordenadas (54,168),//48
        new Coordenadas (32,170),//49
        new Coordenadas (6,172),//50
        new Coordenadas (9,228),//51
        new Coordenadas (6,283),//52
        new Coordenadas (30,284),//53
        new Coordenadas (54,286),//54
        new Coordenadas (78,284),//55
        new Coordenadas (102,279),//56
        new Coordenadas (126,288),//57
        new Coordenadas (148,283),//58
        new Coordenadas (169,283),//59
        new Coordenadas (185,296),//60
        new Coordenadas (184,320),//61
        new Coordenadas (184,340),//62
        new Coordenadas (186,366),//63
        new Coordenadas (185,390),//64
        new Coordenadas (184,410),//65
        new Coordenadas (183,435),//66
        new Coordenadas (186,456),//67
        new Coordenadas (239,454),//68
        
     };
    

    //Falta las coordenadas de camino win ( 7 casillas)
    // las coordenadas del win son temporables, hay que poder las de mi codigo
    private Coordenadas [][] caminoWin = new Coordenadas[][]{
        //Rojo
        {
        new Coordenadas(189, 413),//65
        new Coordenadas(193, 440),//66
        new Coordenadas(187, 463),//67
        },
        //Amarillo
        {
        new Coordenadas(191, 323),//61
        new Coordenadas(198, 342),//62
        new Coordenadas(187, 364),//63
        new Coordenadas(185, 388),//64
        },
        //Azul
        {
        new Coordenadas(79, 290),//55
        new Coordenadas(103, 287),//56
        new Coordenadas(128, 281),//57
        new Coordenadas(147, 284),//58

        },
        //Verde
        {
        
        new Coordenadas(99, 173),//46
        new Coordenadas(78, 176),//47
        new Coordenadas(55, 171),//48
        new Coordenadas(30, 169),//49
        new Coordenadas(9, 173),//50
        }      
    };

    public int getCasillasTotal ()
    {
        return recorrido.length;
    }//fin getCasillasTotal
    
    public Coordenadas getPosicion (int indice)
    {
        return recorrido[indice];
    
    }

    public void AvanzarFicha() {
        if (indice < recorrido.length - 1 ) {
            indice ++;
        }
    }
    public void reiniciar (){
    indice = 0;
    }
    public Coordenadas getCaminoWin (int colorId, int step){
        return caminoWin[colorId][step];
    }

}//fin TableroCoordenadas