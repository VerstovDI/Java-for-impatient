package server;

// Класс, содежащий в себе информацию о заявке
public class Request {
    protected int       processingTime;  // Время обработк в секундах
    protected boolean   needFeedback;    // Признак необходимости отправки подтверждения о выполнении
    protected int       priority;        // Приоритет заявки

    public Request(int processingTime, boolean needFeedback, int priority) {
        this.processingTime = processingTime;
        this.needFeedback = needFeedback;
        this.priority = priority;
    }
}
