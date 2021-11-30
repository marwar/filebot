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
public class Scripts implements Serializable
{

    @SerializedName("scripts")
    @Expose
    private List<Script> scripts = new ArrayList<Script>();
    private final static long serialVersionUID = 3170013953086590923L;

}