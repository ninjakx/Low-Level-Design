package CricketScoring;

public class Pair<T1, T2> {
    T1 pname;
    T2 ptype;
    public Pair(T1 pname, T2 ptype){
        this.pname = pname;
        this.ptype = ptype;
    }
    public T1 getPname(){
        return pname;
    }
    public T2 getPtype(){
        return ptype;
    }
    static <T1, T2> Pair<T1, T2> of(T1 pname, T2 ptype){
        return new Pair<T1, T2>(pname, ptype);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.pname.equals(pairo.getPname()) && this.ptype.equals(pairo.getPtype());
    }
}
