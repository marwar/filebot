package pl.marwar.filebot.scripts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Script implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("matchers")
    @Expose
    private List<Matcher> matchers = new ArrayList<Matcher>();
    @SerializedName("action")
    @Expose
    private Action action;
    private final static long serialVersionUID = 1845086238379493336L;


}