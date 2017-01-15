package Fach_2_Objektorientierung.A11_4_Generics;

class TierKaefig<E> {
    private E insasse;

    public void setInsasse(E x) {
        insasse = x;
    }

    public E getInsasse() {
        return insasse;
    }
}

class Tier {
}

class Katze extends Tier {
}

class Hund extends Tier {
}
