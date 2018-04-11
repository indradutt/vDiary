package com.indra.vdiary.explorer.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.indra.vdiary.R
import com.indra.vdiary.common.data.Content
import com.indra.vdiary.common.data.TextContent
import com.indra.vdiary.common.data.VideoContent
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by indra.dutt on 4/9/18.
 */
class ExplorerRepo {

    fun getExplorerList() : LiveData<List<Content>> {
        val liveData = MutableLiveData<List<Content>>()
        val list = ArrayList<Content>()

        val localPath = "android.resource://" + "com.indra.vdiary" + "/" + R.raw.sample
        list.add(TextContent("10K is usually no more a challenge now but bad days come unannounced, so a runner needs to take each event with due care and attention.",
                "TCS 10K Run",
                Date(),
                Date(),
                "", "http://loremflickr.com/800/600/city?random=2"))

        list.add(VideoContent("Big Buck Bunny" ,
                Date(), Date(),
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                ""))

        list.add(TextContent("Sing with me, sing for the years\n" +
                "Sing for the laughter, sing for the tears",
                "Dream on", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=3"))

        list.add(TextContent("Us and them \n" +
                "And after all we're only ordinary men ", "Us and them", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=2"))

        list.add(TextContent("Far away across the field\n" +
                "The tolling of the iron bell", "Time", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=4"))

        list.add(TextContent("Never stop the car on a drive in the dark\n" +
                "Never look for the truth in your mother's eyes", "Arriving somewhere...", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=1"))

        list.add(TextContent("Hey, hey mama said the way you move\n" +
                "Gon' make you sweat, gon' make you groove", "Black Dog", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=3"))

        list.add(TextContent("Lost in the sky\n" +
                "Clouds roll by and I roll with them\n" +
                "Arrows fly\n" +
                "Seas increase and then fall again", "Pull me under", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=4"))

        list.add(TextContent("At home \n" +
                "Drawing pictures \n" +
                "Of mountain tops \n" +
                "With him on top ", "Jeremy", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=2"))

        list.add(TextContent("Remember when you were young, you shone like the sun.\n" +
                "Shine on you crazy diamond.", "Shine on you crazy diamond", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=3"))

        list.add(TextContent("Son she said \n" +
                "Have I got a little story for you ", "Alive", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=2"))

        list.add(TextContent("Back in black\n" +
                "I hit the sack\n" +
                "I've been too long I'm glad to be back", "Back in Black", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=1"))

        list.add(TextContent("You move in waves\n" +
                "You never retrace\n" +
                "Your newest craze", "Shemovedon", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=3"))

        list.add(TextContent("We passed upon the stair\n" +
                "We spoke of was and when", "Man who sold the world", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=4"))

        list.add(TextContent("By the last breath of the fourth winds blow\n" +
                "Better raise your ears", "Four horsemen", Date(), Date(), "", "http://loremflickr.com/800/600/city?random=1"))

        list.add(VideoContent("Kill Bill", Date(), Date(), localPath, ""))

        liveData.value = list
        return liveData
    }
}