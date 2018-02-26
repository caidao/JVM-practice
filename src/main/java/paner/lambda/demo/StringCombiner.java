package paner.lambda.demo;

public class StringCombiner {

    private StringBuilder builder=new StringBuilder();

    private String delim;

    private String prefix;

    private String suffix;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getDelim() {
        return delim;
    }

    public void setDelim(String delim) {
        this.delim = delim;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public StringCombiner add(String element){
        if (areAtStart()){
            builder.append(prefix);
        }else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other){
        builder.append(other.builder);
        return this;
    }


    private boolean areAtStart(){
        return builder.toString().isEmpty();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
