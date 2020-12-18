package jp.ac.shohoku.s19b708.susutorikibako;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends View{
    public final int FIRST = 1;
    public final int SECOND = 2;
    public final int THIRD = 3;
    public final int FOURTH = 4;

    int state;


    public MainActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        state = FIRST;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        if(state == FIRST) {
            p.setColor(Color.BLUE);
            canvas.drawARGB(255, 255, 255, 255);
            canvas.drawRect(100, 100, 200, 300, p);

        } else if (state == SECOND){
            p.setColor(Color.RED);
            canvas.drawARGB(255, 255, 255, 0);
            canvas.drawRect(100, 100, 200, 300, p);

        } else {
            Log.d("error", "never come here");
        }
        if(state == FIRST) {
            p.setColor(Color.BLUE);
            canvas.drawRect(300, 100, 400, 300, p);

        } else if (state == THIRD){
            p.setColor(Color.BLACK);
            canvas.drawARGB(255, 0, 255, 0);
            canvas.drawRect(300, 100, 400, 300, p);

        } else {
            Log.d("error", "never come here");
        }

        if(state == FIRST) {
            p.setColor(Color.BLUE);
            canvas.drawRect(600, 100, 700, 300, p);

        } else if (state == FOURTH){
            p.setColor(Color.CYAN);
            canvas.drawARGB(255, 255, 0, 0);
            canvas.drawRect(600, 100, 700, 300, p);

        } else {
            Log.d("error", "never come here");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();


        if(x>100 && x < 200 && y>100 && y<300) {
            if(state == FIRST){
                state = SECOND;
            } else if (state == SECOND){
                state = FIRST;
            } else {
                Log.d("error", "never come here");
            }
        }


        if(x>300 && x < 400 && y>100 && y<300) {
            if(state == FIRST){
                state = THIRD;
            } else if (state == THIRD){
                state = FIRST;
            } else {
                Log.d("error", "never come here");
            }
        }


        if(x>600 && x < 700 && y>100 && y<300) {
            if(state == FIRST){
                state = FOURTH;
            } else if (state == FOURTH){
                state = FIRST;
            } else {
                Log.d("error", "never come here");
            }
        }

        invalidate();
        return super.onTouchEvent(event);
    }
}